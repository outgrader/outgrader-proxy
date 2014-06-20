package com.outgrader.modules.impl

import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.support.AbstractApplicationContext

import spock.lang.Specification

import com.outgrader.modules.IApplicationRegistry
import com.outgrader.modules.impl.test.TestConfiguration
import com.outgrader.modules.impl.test.TestModule

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class ApplicationRegistrySpec extends Specification {

	def static registry = ApplicationRegistry.get()

	def "check modules was loaded"() {
		expect:
		registry.getBean(TestModule) != null
	}

	def "check non-modules wasn't loaded"() {
		when:
		registry.getBean(TestConfiguration)

		then:
		thrown(NoSuchBeanDefinitionException)
	}

	def "check ApplicationRegistry available from context"() {
		when:
		def registryFromContext = registry.getBean(IApplicationRegistry)

		then:
		registryFromContext != null
		registry == registryFromContext
	}

	def "check application registry succesfully closed"() {
		setup:
		def registry = Spy(ApplicationRegistry)
		def context = Mock(AbstractApplicationContext)

		registry.getApplicationContext() >> context

		when:
		registry.close()

		then:
		1 * context.close()
	}

	def cleanupSpec() {
		registry.close()
	}
}
