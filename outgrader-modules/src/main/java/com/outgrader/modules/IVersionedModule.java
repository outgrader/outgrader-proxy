package com.outgrader.modules;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public interface IVersionedModule extends IModule {

	String getVersion();

	String getBuildDate();

}
