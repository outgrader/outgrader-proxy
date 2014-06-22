package com.outgrader.modules.impl.mixin;

import com.outgrader.modules.annotations.Module
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixinAdvisor
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixinAdvisorSpec

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class VersionedModuleMixinAdvisorSpec extends AbstractModuleMixinAdvisorSpec {

	@Module(haveVersion = false)
	class UnversionedModule {
	}

	def "check module manually configured to be unversioned didn't match advisor"() {
		expect:
		!advisor.matches(UnversionedModule.class)
	}

	@Override
	public AbstractModuleMixinAdvisor createAdvisor() {
		new VersionedModuleMixinAdvisor()
	}
}
