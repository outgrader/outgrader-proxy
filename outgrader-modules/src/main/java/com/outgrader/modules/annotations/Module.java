package com.outgrader.modules.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Configuration
public @interface Module {

	String value() default "";

	boolean haveVersion() default true;

}
