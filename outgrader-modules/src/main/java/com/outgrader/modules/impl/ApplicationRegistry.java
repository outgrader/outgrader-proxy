package com.outgrader.modules.impl;

import java.io.IOException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.outgrader.modules.IApplicationRegistry;
import com.outgrader.modules.IModule;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class ApplicationRegistry implements IApplicationRegistry {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationRegistry.class);

	private static final class ApplicationRegistryHolder {
		private static final ApplicationRegistry INSTANCE = new ApplicationRegistry();
	}

	private ApplicationContext applicationContext;

	protected ApplicationRegistry() {
		registerApplicationRegistry();
	}

	public static IApplicationRegistry get() {
		return ApplicationRegistryHolder.INSTANCE;
	}

	@Override
	public synchronized void close() throws IOException {
		LOGGER.info("Closing application context");

		((AbstractApplicationContext) getApplicationContext()).close();
		applicationContext = null;

		LOGGER.info("Application context closed");
	}

	protected ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			LOGGER.info("Initializing application context");

			applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		}

		return applicationContext;
	}

	protected void registerApplicationRegistry() {
		final BeanFactory beanFactory = ((ConfigurableApplicationContext) getApplicationContext()).getBeanFactory();

		((DefaultListableBeanFactory) beanFactory).registerSingleton("applicationRegistry", this);
	}

	@Override
	public <T> T getBean(final Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	@Override
	public Collection<IModule> getModules() {
		return getModules(IModule.class);
	}

	@Override
	public IModule getModule(final String name) {
		return getModule(name, IModule.class);
	}

	@Override
	public IModule getRootModule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends IModule> Collection<T> getModules(final Class<T> clazz) {
		return getApplicationContext().getBeansOfType(clazz).values();
	}

	@Override
	public <T extends IModule> T getModule(final String name, final Class<T> clazz) {
		return getApplicationContext().getBeansOfType(clazz).get(name);
	}
}
