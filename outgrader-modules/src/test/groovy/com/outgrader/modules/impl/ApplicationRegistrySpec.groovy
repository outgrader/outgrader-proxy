package com.outgrader.modules.impl

import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.support.AbstractApplicationContext

import spock.lang.Ignore
import spock.lang.Specification

import com.outgrader.modules.IApplicationRegistry
import com.outgrader.modules.INamedModule
import com.outgrader.modules.IVersionedModule
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

	def "check loaded modules"() {
		expect:
		registry.getModules() != null
		registry.getModules().size() == 2
	}

	def "check modules by name"() {
		expect:
		registry.getModule('testModule') != null
		registry.getModule('some name') != null
	}

	@Ignore
	def "check modules hierarchy"() {
		when:
		def module = registry.getRootModule()

		then:
		module != null
		module.name == 'testModule'
		module.parent == null
		module.chilren.size() == 1

		def submodule = module.children.first
		submodule.name == 'some name'
		submodule.parent == module
		submodule.children.isEmpty()
	}

	def "check only versioned modules"() {
		expect:
		registry.getModules(IVersionedModule.class) != null
		registry.getModules(IVersionedModule.class).size() == 1
	}

	def "check only version module by name"() {
		expect:
		registry.getModule('some name', IVersionedModule.class) != null
		registry.getModule('testModule', IVersionedModule.class) == null
	}

	def "check default bean name as module name"() {
		setup:
		INamedModule module = registry.getModule('testModule', INamedModule)

		when:
		def name = module.getName()

		then:
		name == 'testModule'
	}

	def "check annotation congiured name as module name"() {
		expect:
		registry.getModule('some name').getName() == 'some name'
	}

	def cleanupSpec() {
		registry.close()
	}
}

