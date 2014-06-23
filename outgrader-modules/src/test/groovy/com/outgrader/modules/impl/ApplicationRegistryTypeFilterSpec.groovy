package com.outgrader.modules.impl

import org.springframework.core.type.classreading.CachingMetadataReaderFactory
import org.springframework.core.type.classreading.MetadataReaderFactory
import org.springframework.core.type.filter.TypeFilter

import spock.lang.Specification

import com.outgrader.modules.impl.ApplicationRegistryTypeFilter;
import com.outgrader.modules.impl.test.TestConfiguration
import com.outgrader.modules.impl.test.TestModule

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class ApplicationRegistryTypeFilterSpec extends Specification {

	MetadataReaderFactory factory = new CachingMetadataReaderFactory()

	TypeFilter typeFilter = new ApplicationRegistryTypeFilter()

	def "check type filter successed for non-module class"() {
		setup:
		def metadata = factory.getMetadataReader(TestConfiguration.name)

		expect:
		typeFilter.match(metadata, factory)
	}

	def "check type filter failed for module class"() {
		setup:
		def metadata = factory.getMetadataReader(TestModule.name)

		expect:
		!typeFilter.match(metadata, factory)
	}
}
