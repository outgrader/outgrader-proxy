package com.outgrader.modules.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.outgrader.modules.IApplicationRegistry;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public final class ApplicationRegistry implements IApplicationRegistry {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationRegistry.class);

	private static final class ApplicationRegistryHolder {
		private static final ApplicationRegistry INSTANCE = new ApplicationRegistry();
	}

	private ApplicationContext applicationContext;

	// hide constructor
	private ApplicationRegistry() {

	}

	public static IApplicationRegistry get() {
		return ApplicationRegistryHolder.INSTANCE;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

	protected ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			LOGGER.info("Initializing application context");

			applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		}

		return applicationContext;
	}

	protected void registerApplicationRegistry() {

	}

	@Override
	public <T> T getBean(final Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}
}
