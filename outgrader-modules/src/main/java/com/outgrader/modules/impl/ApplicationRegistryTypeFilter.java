package com.outgrader.modules.impl;

import java.io.IOException;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import com.outgrader.modules.annotations.Module;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class ApplicationRegistryTypeFilter implements TypeFilter {

	private static final TypeFilter MODULES_FILTER = new AnnotationTypeFilter(Module.class, false, false);

	@Override
	public boolean match(final MetadataReader metadataReader, final MetadataReaderFactory metadataReaderFactory) throws IOException {
		return !MODULES_FILTER.match(metadataReader, metadataReaderFactory);
	}

}
