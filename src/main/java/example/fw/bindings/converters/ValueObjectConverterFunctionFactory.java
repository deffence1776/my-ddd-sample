package example.fw.bindings.converters;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

public abstract class ValueObjectConverterFunctionFactory<T> {

    private Class<T> parameterType;

    public ValueObjectConverterFunctionFactory(Class<T> parameterType) {
        this.parameterType = parameterType;
    }

    Function<String, Object> getValueObjectConverterFunction(Class targetValueObject) {
        try {
            var constructor = getConstructor(targetValueObject);
            return str -> {
                try {
                    return constructor.newInstance(toType(str));
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new IllegalStateException(e);
                }
            };
        } catch (NoSuchMethodException ex) {
            return null;
        }
    }

    Class<T> getType() {
        return parameterType;
    }

    protected abstract Constructor<T> getConstructor(Class targetValueObject) throws NoSuchMethodException;

    protected abstract T toType(String s);
}
