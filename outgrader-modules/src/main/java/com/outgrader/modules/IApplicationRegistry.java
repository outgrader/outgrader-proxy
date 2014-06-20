package com.outgrader.modules;

import java.io.Closeable;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public interface IApplicationRegistry extends Closeable {

	<T> T getBean(Class<T> clazz);

}
