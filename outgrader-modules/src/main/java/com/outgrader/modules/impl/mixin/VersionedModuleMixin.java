package com.outgrader.modules.impl.mixin;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import com.outgrader.modules.IVersionedModule;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class VersionedModuleMixin extends DelegatingIntroductionInterceptor implements IVersionedModule {

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
