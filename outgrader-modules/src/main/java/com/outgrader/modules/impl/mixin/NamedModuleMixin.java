package com.outgrader.modules.impl.mixin;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import com.outgrader.modules.INamedModule;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class NamedModuleMixin extends DelegatingIntroductionInterceptor implements INamedModule {

	private static final long serialVersionUID = 3928049614432943723L;

	@Override
	public String getName() {
		return "lalalal";
	}

}
