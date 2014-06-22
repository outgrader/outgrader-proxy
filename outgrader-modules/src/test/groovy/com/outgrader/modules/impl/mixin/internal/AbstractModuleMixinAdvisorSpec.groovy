package com.outgrader.modules.impl.mixin.internal

import spock.lang.Specification

import com.outgrader.modules.annotations.Module


/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
abstract class AbstractModuleMixinAdvisorSpec extends Specification {

	@Module
	class AnnotatedModule {
	}

	class NotAnnotatedModule {
	}

	def advisor = createAdvisor()

	def "check advisor will be applied for annotated class"() {
		expect:
		advisor.matches(AnnotatedModule)
	}

	def "check advisor will not be applied for not-annotated class"() {
		expect:
		!advisor.matches(NotAnnotatedModule)
	}



	abstract AbstractModuleMixinAdvisor createAdvisor()
}
