package example.infra.datasource.common.annotation;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;


@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Mapper
@Component
public @interface DatasourceMapper {
    // Interface Mapper
}