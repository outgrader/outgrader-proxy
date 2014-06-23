package com.outgrader.modules.impl;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;

import com.outgrader.modules.annotations.ExcludeExceptModuleTypeFilter;
import com.outgrader.modules.annotations.ModuleAnnotationPostProcessor;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.outgrader", excludeFilters = @Filter(type = FilterType.CUSTOM, value = ExcludeExceptModuleTypeFilter.class))
@ImportResource("classpath:META-INF/outgrader-modules/spring/applicationContext.xml")
public class ApplicationConfiguration {

	@Bean
	public BeanDefinitionRegistryPostProcessor moduleAnnotationPostProcessor() {
		return new ModuleAnnotationPostProcessor();
	}

}
