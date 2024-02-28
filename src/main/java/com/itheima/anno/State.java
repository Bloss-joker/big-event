package com.itheima.anno;

import com.itheima.validation.StateValidition;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Constraint(validatedBy = {StateValidition.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface State {
    //提供校验失败后的提示
    String message() default "state的参数只能是已发布或者是草稿";
    //分组
    Class<?>[] groups() default { };
    //负载
    Class<? extends Payload>[] payload() default { };
}
