package com.outgrader.modules.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.outgrader.modules.annotations.ExcludeExceptModuleTypeFilter;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
@Configuration
@ComponentScan(basePackages = "com.outgrader", excludeFilters = @Filter(type = FilterType.CUSTOM, value = ExcludeExceptModuleTypeFilter.class))
public class ApplicationConfiguration {

}
