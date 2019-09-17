package example.fw.bindings.converters.factories;

import example.fw.bindings.converters.ValueObjectConverterFunctionFactory;

import java.lang.reflect.Constructor;

public class StringConverterFunctionFactory extends ValueObjectConverterFunctionFactory<String> {

    public StringConverterFunctionFactory() {
        super(String.class);
    }

    @Override
    public Constructor<String> getConstructor(Class targetValueObject) throws NoSuchMethodException {
        return targetValueObject.getConstructor(String.class);
    }
    @Override
    public String toType(String s) {
        return s;
    }
}
