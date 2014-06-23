package com.outgrader.modules.impl.mixin.internal;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public abstract class AbstractModuleMixin extends DelegatingIntroductionInterceptor {

	private static final long serialVersionUID = -3425215042908903049L;

	private final ThreadLocal<Object> thisMap = new ThreadLocal<>();

	protected Object getThis() {
		return thisMap.get();
	}

	@Override
	public Object invoke(final MethodInvocation mi) throws Throwable {
		thisMap.set(mi.getThis());
		return super.invoke(mi);
	}

}
