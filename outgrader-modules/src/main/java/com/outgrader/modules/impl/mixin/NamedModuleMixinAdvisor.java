package com.outgrader.modules.impl.mixin;

import com.outgrader.modules.INamedModule;
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixinAdvisor;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class NamedModuleMixinAdvisor extends AbstractModuleMixinAdvisor {

	private static final long serialVersionUID = 7058882893152008249L;

	public NamedModuleMixinAdvisor() {
		super(new NamedModuleMixin(), INamedModule.class);
	}

}
