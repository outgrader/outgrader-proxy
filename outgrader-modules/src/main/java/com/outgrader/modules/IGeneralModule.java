package com.outgrader.modules;

import java.util.Set;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public interface IGeneralModule extends IModule {

	String getName();

	IModule getParent();

	Set<IModule> getChildren();

}
