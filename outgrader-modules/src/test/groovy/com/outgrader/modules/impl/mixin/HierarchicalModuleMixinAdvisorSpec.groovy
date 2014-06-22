package com.outgrader.modules.impl.mixin;

import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixinAdvisor
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixinAdvisorSpec

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class HierarchicalModuleMixinAdvisorSpec extends
AbstractModuleMixinAdvisorSpec {

	@Override
	public AbstractModuleMixinAdvisor createAdvisor() {
		new HierarchicalModuleMixinAdvisor()
	}
}
