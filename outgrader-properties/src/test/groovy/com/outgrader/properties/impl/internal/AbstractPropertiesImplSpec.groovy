package com.outgrader.properties.impl.internal

import org.apache.commons.configuration.AbstractConfiguration
import org.apache.commons.configuration.Configuration
import org.apache.commons.configuration.FileConfiguration

import spock.lang.Specification

import com.outgrader.properties.impl.IPropertySource

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class AbstractPropertiesImplSpec extends Specification {

	final static STATISTICS_NAME = 'statistics'

	AbstractPropertiesImpl properties = Spy(AbstractPropertiesImpl.class, constructorArgs: [STATISTICS_NAME])

	IPropertySource propertySource = Mock(IPropertySource)

	Configuration configuration = Mock(Configuration)

	Configuration abstractConfiguration = Spy(AbstractConfiguration)

	Configuration fileConfiguration = Mock(FileConfiguration)

	def "check NPE on initialization without property source"() {
		when:
		properties.initialize()

		then:
		thrown(NullPointerException)
	}

	def "check initialization for general configuraiton"() {
		setup:
		properties.setPropertySource(propertySource)

		when:
		properties.initialize()

		then:
		1 * propertySource.getConfiguration() >> configuration
		properties.getConfiguration() == configuration
	}

	def "check initialization for configuraiton with event support"() {
		setup:
		properties.setPropertySource(propertySource)

		when:
		properties.initialize()

		then:
		1 * propertySource.getConfiguration() >> abstractConfiguration
		1 * abstractConfiguration.addConfigurationListener(_)
		properties.getConfiguration() == abstractConfiguration
	}

	def "check cleanup for general configuration"() {
		setup:
		properties.setPropertySource(propertySource)
		propertySource.getConfiguration() >> configuration
		properties.initialize()

		when:
		properties.cleanup()

		then:
		0 * configuration._
	}

	def "check cleanup for unchanged file configuration"() {
		setup:
		properties.setPropertySource(propertySource)
		propertySource.getConfiguration() >> fileConfiguration
		properties.initialize()
		properties.changed = false

		when:
		properties.cleanup()

		then:
		0 * configuration._
	}

	def "check cleanup for changed file configuration"() {
		setup:
		properties.setPropertySource(propertySource)
		propertySource.getConfiguration() >> fileConfiguration
		properties.initialize()
		properties.changed = true

		when:
		properties.cleanup()

		then:
		1 * fileConfiguration.save()
	}

	def "check properties marked as changed"() {
		setup:
		properties.setPropertySource(propertySource)
		propertySource.getConfiguration() >> abstractConfiguration
		properties.initialize()

		when:
		abstractConfiguration.setProperty('property', 'value')

		then:
		1 * abstractConfiguration.addProperty('property', 'value') >> null
		properties.changed
	}

	def "check NPE when property source returned null configuration"() {
		setup:
		properties.setPropertySource(propertySource)
		propertySource.getConfiguration() >> null

		when:
		properties.initialize()

		then:
		thrown(NullPointerException)
	}
}
