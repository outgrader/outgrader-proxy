package com.outgrader.modules.impl.mixin;

import java.util.Set;

import com.outgrader.modules.IHierarchicalModule;
import com.outgrader.modules.IModule;
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixin;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class HierarchicalModuleMixin extends AbstractModuleMixin<Object> implements IHierarchicalModule {

	private static final long serialVersionUID = 3928049614432943723L;

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

	@Override
	protected Object createObject(final Object thisInstance) {
		// TODO Auto-generated method stub
		return null;
	}

}
