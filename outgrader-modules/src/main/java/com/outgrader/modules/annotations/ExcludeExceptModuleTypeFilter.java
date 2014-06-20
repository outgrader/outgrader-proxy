package com.outgrader.modules.annotations;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class ExcludeExceptModuleTypeFilter extends AnnotationTypeFilter {

	public ExcludeExceptModuleTypeFilter() {
		super(Module.class, false, false);
	}

	@Override
	protected boolean matchSelf(final MetadataReader metadataReader) {
		return !super.matchSelf(metadataReader);
	}

}
