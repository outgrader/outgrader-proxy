package com.outgrader.modules.impl.mixin.internal;

import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.core.annotation.AnnotationUtils;

import com.outgrader.modules.annotations.Module;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public abstract class AbstractModuleMixinAdvisor extends DefaultIntroductionAdvisor {

	private static final long serialVersionUID = -5261840264136793661L;

	protected AbstractModuleMixinAdvisor(final AbstractModuleMixin<?> advice, final Class<?> intf) {
		super(advice, intf);
	}

	@Override
	public boolean matches(final Class<?> clazz) {
		return AnnotationUtils.findAnnotation(clazz, Module.class) != null;
	}
}
