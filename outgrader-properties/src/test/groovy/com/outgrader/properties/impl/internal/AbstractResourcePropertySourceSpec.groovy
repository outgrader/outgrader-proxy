package com.outgrader.properties.impl.internal

import org.apache.commons.configuration.Configuration
import org.apache.commons.configuration.ConfigurationException
import org.springframework.core.io.Resource

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class AbstractResourcePropertySourceSpec extends Specification {

	AbstractResourcePropertySource propertySource = Spy(AbstractResourcePropertySource)

	Configuration configuration = Mock(Configuration)

	Resource resource = Mock(Resource)

	InputStream inputStream = Mock(InputStream)

	def setup() {
		resource.getInputStream() >> inputStream
	}

	def "check configuration resource was found"() {
		setup:
		propertySource.getLocationCandidates() >> [
			'missingresource.properties',
			'com/outgrader/properties/impl/internal/AbstractResourcePropertySourceSpec.class'
		]

		when:
		def result = propertySource.getConfigurationResource()

		then:
		result != null
	}

	def "check configuration resource was not found"() {
		setup:
		propertySource.getLocationCandidates() >> [
			'missingresource.properties',
			'com/outgrader/properties/impl/internal/Missing.groovy'
		]

		when:
		def result = propertySource.getConfigurationResource()

		then:
		noExceptionThrown()
		result == null
	}

	def "check NPE when configuration resource was not found"() {
		setup:
		propertySource.getConfigurationResource() >> null

		when:
		propertySource.getConfiguration()

		then:
		thrown(NullPointerException)
	}

	@Unroll
	def "check error when configuration creation failed"(def error) {
		setup:
		propertySource.getConfigurationResource() >> resource
		propertySource.createConfiguration(resource) >> {throw error }

		when:
		propertySource.getConfiguration()

		then:
		thrown(RuntimeException)

		where:
		error << [
			new IOException(),
			new ConfigurationException()
		]
	}

	def "check configuration initialized"() {
		setup:
		propertySource.getConfigurationResource() >> resource
		propertySource.createConfiguration(resource) >> configuration

		when:
		def result = propertySource.getConfiguration()

		then:
		result == configuration
	}
}
