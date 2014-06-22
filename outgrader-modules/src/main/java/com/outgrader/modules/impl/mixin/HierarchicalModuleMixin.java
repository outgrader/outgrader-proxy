package com.outgrader.modules.impl.mixin;

import java.util.Set;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import com.outgrader.modules.IHierarchicalModule;
import com.outgrader.modules.IModule;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class HierarchicalModuleMixin extends DelegatingIntroductionInterceptor implements IHierarchicalModule {

	private static final long serialVersionUID = 3928049614432943723L;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IModule getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<IModule> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}
