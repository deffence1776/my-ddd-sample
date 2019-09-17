package example.fw.bindings.converters.factories;

import example.domain.common.type.Date;
import example.fw.bindings.converters.ValueObjectConverterFunctionFactory;

import java.lang.reflect.Constructor;

public class DateConverterFunctionFactory extends ValueObjectConverterFunctionFactory<Date> {
    public DateConverterFunctionFactory() {
        super(Date.class);
    }

    @Override
    public Constructor<Date> getConstructor(Class targetValueObject) throws NoSuchMethodException {
        return targetValueObject.getConstructor(Date.class);
    }

    @Override
    public Date toType(String s) {
        return new Date(s);
    }
}
