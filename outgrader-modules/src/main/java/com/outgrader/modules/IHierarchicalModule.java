package com.outgrader.modules;

import java.util.Set;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public interface IHierarchicalModule extends IModule {

	IModule getParent();

	Set<IModule> getChildren();

}
