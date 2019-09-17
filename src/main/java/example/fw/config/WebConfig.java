package example.fw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import example.domain.common.type.Date;
import example.fw.bindings.converters.GenericValueObjectConverter;
import example.fw.bindings.converters.factories.DateConverterFunctionFactory;
import example.fw.bindings.converters.factories.IntConverterFunctionFactory;
import example.fw.bindings.converters.factories.StringConverterFunctionFactory;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new GenericValueObjectConverter(
                new StringConverterFunctionFactory(),
                new IntConverterFunctionFactory(),
                new DateConverterFunctionFactory()));
    }
}
