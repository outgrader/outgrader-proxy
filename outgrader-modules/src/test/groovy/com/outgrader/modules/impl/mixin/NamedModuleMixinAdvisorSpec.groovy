package com.outgrader.modules.impl.mixin;

import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixinAdvisor
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixinAdvisorSpec

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class NamedModuleMixinAdvisorSpec extends AbstractModuleMixinAdvisorSpec {

	@Override
	public AbstractModuleMixinAdvisor createAdvisor() {
		new NamedModuleMixinAdvisor()
	}
}
