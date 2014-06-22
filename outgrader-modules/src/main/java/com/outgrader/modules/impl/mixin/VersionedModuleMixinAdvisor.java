package com.outgrader.modules.impl.mixin;

import org.springframework.core.annotation.AnnotationUtils;

import com.outgrader.modules.IVersionedModule;
import com.outgrader.modules.annotations.Module;
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixinAdvisor;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class VersionedModuleMixinAdvisor extends AbstractModuleMixinAdvisor {

	private static final long serialVersionUID = -7457323621206923116L;

	public VersionedModuleMixinAdvisor() {
		super(new VersionedModuleMixin(), IVersionedModule.class);
	}

	@Override
	public boolean matches(final Class<?> clazz) {
		boolean result = super.matches(clazz);

		if (result) {
			final Module moduleAnnotation = AnnotationUtils.findAnnotation(clazz, Module.class);

			result = moduleAnnotation.haveVersion();
		}

		return result;
	}

}
