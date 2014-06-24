package com.outgrader.properties.impl.internal

import org.apache.commons.configuration.PropertiesConfiguration
import org.springframework.core.io.ClassPathResource

import spock.lang.Specification

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class AbstractPropertiesFileSourceSpec extends Specification {

	AbstractPropertiesFileSource propertySource = Spy(AbstractPropertiesFileSource)

	def "check created property source"() {
		setup:
		def resource = new ClassPathResource('test.properties')

		when:
		def result = propertySource.createConfiguration(resource)

		then:
		result instanceof PropertiesConfiguration
	}
}
