package com.outgrader.modules.impl.mixin;

import com.outgrader.modules.IVersionedModule;
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixin;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class VersionedModuleMixin extends AbstractModuleMixin implements IVersionedModule {

	private static final long serialVersionUID = -4107243833638189582L;

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBuildDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
