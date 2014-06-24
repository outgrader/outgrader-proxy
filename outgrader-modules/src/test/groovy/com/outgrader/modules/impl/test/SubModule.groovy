package com.outgrader.modules.impl.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

import com.outgrader.modules.annotations.Module

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
@Module('some name')
@Import(TestModule.class)
class SubModule {

	@Autowired
	@Qualifier('qualified')
	Object moduleBean

	@Bean def anotherBean() {
		return moduleBean.toString()
	}
}
