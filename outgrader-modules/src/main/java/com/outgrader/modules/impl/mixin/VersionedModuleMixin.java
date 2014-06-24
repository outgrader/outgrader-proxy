package com.outgrader.modules.impl.mixin;

import com.outgrader.modules.IVersionedModule;
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixin;
import com.outgrader.modules.impl.mixin.version.VersionProperties;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class VersionedModuleMixin extends AbstractModuleMixin<VersionProperties> implements IVersionedModule {

	private static final long serialVersionUID = -4107243833638189582L;

	@Override
	public String getVersion() {
		return get().getVersion();
	}

	@Override
	public String getBuildDate() {
		return get().getBuildDate();
	}

	@Override
	protected VersionProperties createObject(final Object thisInstance) {
		return new VersionProperties(ModuleMixinUtils.getModuleName(thisInstance));
	}
}
