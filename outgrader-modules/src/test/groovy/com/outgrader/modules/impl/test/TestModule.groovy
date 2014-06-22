package com.outgrader.modules.impl.test

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean

import com.outgrader.modules.annotations.Module

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
@Module(haveVersion = false)
class TestModule {

	@Bean
	@Qualifier('qualified')
	def Object someBean() {
		new Object()
	}
}
