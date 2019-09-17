package example.fw.bindings.converters;

import org.springframework.core.ResolvableType;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.util.ConcurrentReferenceHashMap;
import example.fw.bindings.validations.ValueObject;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class GenericValueObjectConverter implements ConditionalGenericConverter {

    private static final Map<Class<?>, Function<String, Object>> conversionMemberCache =
            new ConcurrentReferenceHashMap<>(32);

    private final Map<Class<?>, ValueObjectConverterFunctionFactory> factories = new ConcurrentReferenceHashMap<>(32);

    public GenericValueObjectConverter(ValueObjectConverterFunctionFactory... factories) {
        for (ValueObjectConverterFunctionFactory factory : factories) {
            this.factories.put(factory.getType(), factory);
        }
    }

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return targetType.hasAnnotation(ValueObject.class) && sourceType.getObjectType().equals(String.class);
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Set.of(new ConvertiblePair(String.class, Object.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {

        if (source == null) {
            return null;
        }

        ValueObject voAnnotation = targetType.getAnnotation(ValueObject.class);
        if (voAnnotation.emptyToNull() == true && "".equals(source)) {
            return null;
        }

        Class targetTypeObjectType = targetType.getObjectType();
        var func = conversionMemberCache.get(targetTypeObjectType);
        if (null == func) {
            func = getConstructorInvokeFunction(targetTypeObjectType, voAnnotation.parameterType());
            conversionMemberCache.put(targetTypeObjectType, func);
        }
        return func.apply((String) source);

    }

    private Function getConstructorInvokeFunction(Class targetTypeObjectType, Class<?> parameterType) {

        var factoryForParameter = factories.get(parameterType);
        var func = factoryForParameter.getValueObjectConverterFunction(targetTypeObjectType);

        if (func != null) {
            return func;
        }
        throw new IllegalStateException("適切なコンストラクタが見つかりません。target:" + targetTypeObjectType + " parameterType:" + parameterType);

    }
}
