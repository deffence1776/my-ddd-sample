package example.fw.bindings.converters.factories;

import example.domain.common.type.Time;
import example.fw.bindings.converters.ValueObjectConverterFunctionFactory;

import java.lang.reflect.Constructor;

public class TimeConverterFunctionFactory extends ValueObjectConverterFunctionFactory<Time> {
    public TimeConverterFunctionFactory() {
        super(Time.class);
    }

    @Override
    public Constructor<Time> getConstructor(Class targetValueObject) throws NoSuchMethodException {
        return targetValueObject.getConstructor(Time.class);
    }

    @Override
    public Time toType(String s) {
        return new Time(s);
    }
}
