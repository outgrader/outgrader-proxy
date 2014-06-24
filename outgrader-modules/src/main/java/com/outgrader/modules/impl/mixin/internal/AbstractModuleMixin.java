package com.outgrader.modules.impl.mixin.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public abstract class AbstractModuleMixin<O extends Object> extends DelegatingIntroductionInterceptor {

	private static final long serialVersionUID = -3425215042908903049L;

	private final ThreadLocal<Object> thisMap = new ThreadLocal<>();

	private final Map<Object, O> cache = new ConcurrentHashMap<>();

	protected Object getThis() {
		return thisMap.get();
	}

	@Override
	public Object invoke(final MethodInvocation mi) throws Throwable {
		thisMap.set(mi.getThis());
		return super.invoke(mi);
	}

	protected O get() {
		final Object thisObject = getThis();

		O result = cache.get(thisObject);

		if (result == null) {
			result = createObject(thisObject);

			final O existing = cache.put(thisObject, result);

			result = existing == null ? result : existing;
		}

		return result;
	}

	protected abstract O createObject(Object thisInstance);

}
