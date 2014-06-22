package com.outgrader.modules.impl.mixin;

import com.outgrader.modules.IHierarchicalModule;
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixinAdvisor;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class HierarchicalModuleMixinAdvisor extends AbstractModuleMixinAdvisor {

	private static final long serialVersionUID = 7058882893152008249L;

	public HierarchicalModuleMixinAdvisor() {
		super(new HierarchicalModuleMixin(), IHierarchicalModule.class);
	}

}
