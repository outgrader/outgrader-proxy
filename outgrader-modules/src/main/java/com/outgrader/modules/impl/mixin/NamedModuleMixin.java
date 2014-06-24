package com.outgrader.modules.impl.mixin;

import com.outgrader.modules.INamedModule;
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixin;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class NamedModuleMixin extends AbstractModuleMixin<String> implements INamedModule {

	private static final long serialVersionUID = 3928049614432943723L;

	@Override
	public String getName() {
		return get();
	}

	@Override
	protected String createObject(final Object thisInstance) {
		return ModuleMixinUtils.getModuleName(thisInstance);
	}

}
