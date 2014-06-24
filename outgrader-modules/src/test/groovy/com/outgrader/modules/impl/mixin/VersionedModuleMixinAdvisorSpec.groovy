package com.outgrader.modules.impl.mixin;

import spock.lang.Specification

import com.outgrader.modules.annotations.Module

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class VersionedModuleMixinAdvisorSpec extends Specification {

	@Module(haveVersion = false)
	class UnversionedModule {
	}

	def "check module manually configured to be unversioned didn't match advisor"() {
		expect:
		!new VersionedModuleMixinAdvisor().matches(UnversionedModule.class)
	}
}
