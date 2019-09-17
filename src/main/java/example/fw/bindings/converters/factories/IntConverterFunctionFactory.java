package example.fw.bindings.converters.factories;

import example.fw.bindings.converters.ValueObjectConverterFunctionFactory;

import java.lang.reflect.Constructor;

public class IntConverterFunctionFactory extends ValueObjectConverterFunctionFactory<Integer> {

    public IntConverterFunctionFactory() {
        super(Integer.class);
    }

    @Override
    public Constructor<Integer> getConstructor(Class targetValueObject) throws NoSuchMethodException {
        try {
            return targetValueObject.getConstructor(int.class);
        } catch (NoSuchMethodException e) {
            return targetValueObject.getConstructor(Integer.class);
        }
    }
    @Override
    public Integer toType(String s) {
        return Integer.parseInt(s);
    }
}
