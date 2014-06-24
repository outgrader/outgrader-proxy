package com.outgrader.modules.impl.mixin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;

import com.outgrader.modules.annotations.Module;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class ModuleMixinUtils {

	private ModuleMixinUtils() {

	}

	public static String getModuleName(final Object moduleInstance) {
		return getModuleName(moduleInstance.getClass());
	}

	private static String getModuleName(final Class<?> clazz) {
		return getModuleName(clazz, AnnotationUtils.findAnnotation(clazz, Module.class));
	}

	private static String getModuleName(final Class<?> clazz, final Module annotation) {
		String result = annotation.value();

		if (StringUtils.isEmpty(result)) {
			result = StringUtils.uncapitalize(getRealClass(clazz).getSimpleName());
		}

		return result;
	}

	private static Class<?> getRealClass(final Class<?> clazz) {
		if (ClassUtils.isCglibProxyClass(clazz)) {
			return getRealClass(clazz.getSuperclass());
		}

		return clazz;
	}
}
