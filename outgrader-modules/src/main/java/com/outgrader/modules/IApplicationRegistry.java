package com.outgrader.modules;

import java.io.Closeable;
import java.util.Collection;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public interface IApplicationRegistry extends Closeable {

	<T> T getBean(Class<T> clazz);

	Collection<IModule> getModules();

	IModule getModule(String name);

	IModule getRootModule();

	<T extends IModule> Collection<T> getModules(Class<T> clazz);

	<T extends IModule> T getModule(String name, Class<T> clazz);

}
