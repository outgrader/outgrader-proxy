package com.outgrader.modules.impl

import org.springframework.beans.factory.NoSuchBeanDefinitionException

import spock.lang.Specification

import com.outgrader.modules.impl.test.TestConfiguration

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class ApplicationRegistrySpec extends Specification {

	def "check application registry was loaded"() {
		when:
		ApplicationRegistry.get()

		then:
		noExceptionThrown()
	}

	def "check modules was loaded"() {
	}

	def "check non-modules wasn't loaded"() {
		setup:
		def registry = ApplicationRegistry.get()

		when:
		registry.getBean(TestConfiguration)

		then:
		thrown(NoSuchBeanDefinitionException)
	}
}
