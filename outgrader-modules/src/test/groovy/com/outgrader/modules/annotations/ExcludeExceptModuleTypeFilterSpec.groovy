package com.outgrader.modules.annotations

import org.springframework.core.type.classreading.CachingMetadataReaderFactory
import org.springframework.core.type.classreading.MetadataReaderFactory
import org.springframework.core.type.filter.TypeFilter

import spock.lang.Specification

import com.outgrader.modules.impl.test.TestConfiguration
import com.outgrader.modules.impl.test.TestModule

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class ExcludeExceptModuleTypeFilterSpec extends Specification {

	MetadataReaderFactory factory = new CachingMetadataReaderFactory()

	TypeFilter typeFilter = new ExcludeExceptModuleTypeFilter()

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
