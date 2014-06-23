package com.outgrader.modules.impl.mixin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;

import com.outgrader.modules.INamedModule;
import com.outgrader.modules.annotations.Module;
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixin;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class NamedModuleMixin extends AbstractModuleMixin implements INamedModule {

	private static final long serialVersionUID = 3928049614432943723L;

	private final Map<Object, String> nameCache = new ConcurrentHashMap<>();

	@Override
	public String getName() {
		final Object thisObject = getThis();
		String result = nameCache.get(thisObject);

		if (result == null) {
			result = getName(thisObject);

			final String putResult = nameCache.put(thisObject, result);

			result = putResult == null ? result : putResult;
		}

		return result;
	}

	private String getName(final Object instance) {
		return getName(instance.getClass());
	}

	private String getName(final Class<?> clazz) {
		return getName(clazz, AnnotationUtils.findAnnotation(clazz, Module.class));
	}

	private String getName(final Class<?> clazz, final Module annotation) {
		String result = annotation.value();

		if (StringUtils.isEmpty(result)) {
			result = StringUtils.uncapitalize(getRealClass(clazz).getSimpleName());
		}

		return result;
	}

	private Class<?> getRealClass(final Class<?> clazz) {
		if (ClassUtils.isCglibProxyClass(clazz)) {
			return getRealClass(clazz.getSuperclass());
		}

		return clazz;
	}
}
