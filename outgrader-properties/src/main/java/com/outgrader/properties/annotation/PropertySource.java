package com.outgrader.properties.annotation;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public @interface PropertySource {

	String[] value();

	PropertySourceType type() default PropertySourceType.PROPERTIES;

}
