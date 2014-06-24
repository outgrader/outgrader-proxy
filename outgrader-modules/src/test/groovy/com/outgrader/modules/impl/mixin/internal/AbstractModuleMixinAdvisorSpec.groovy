package com.outgrader.modules.impl.mixin.internal

import spock.lang.Specification

import com.outgrader.modules.annotations.Module


/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class AbstractModuleMixinAdvisorSpec extends Specification {

	@Module
	class AnnotatedModule {
	}

	class NotAnnotatedModule {
	}

	AbstractModuleMixin mixin = Mock(AbstractModuleMixin)

	Class clazz = Comparable.class

	def advisor = Spy(AbstractModuleMixinAdvisor, constructorArgs: [mixin, clazz])

	def "check advisor will be applied for annotated class"() {
		expect:
		advisor.matches(AnnotatedModule)
	}

	def "check advisor will not be applied for not-annotated class"() {
		expect:
		!advisor.matches(NotAnnotatedModule)
	}
}
