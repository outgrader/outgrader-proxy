package com.outgrader.modules.impl.mixin

import spock.lang.Specification

import com.outgrader.modules.annotations.Module

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class ModuleMixinUtilsSpec extends Specification {

	@Module
	class Default {
	}

	@Module('name')
	class Named {
	}

	def "check name of module without annotation config"() {
		when:
		def name = ModuleMixinUtils.getModuleName(new Default())

		then:
		name == 'default'
	}

	def "check name of module with annotation config"() {
		when:
		def name = ModuleMixinUtils.getModuleName(new Named())

		then:
		name == 'name'
	}
}
