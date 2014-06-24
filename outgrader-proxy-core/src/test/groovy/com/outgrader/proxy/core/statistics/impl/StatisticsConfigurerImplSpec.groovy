package com.outgrader.proxy.core.statistics.impl

import spock.lang.Specification
import spock.lang.Unroll

import com.outgrader.proxy.core.properties.IProxyProperties

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class StatisticsConfigurerImplSpec extends Specification {

	IProxyProperties properties = Mock(IProxyProperties)

	@Unroll
	def "check statistics period is not-positive"(def value) {
		setup:
		properties.statisticsExportPeriod >> value

		when:
		new StatisticsConfigurerImpl(properties).resolveTimestamp(System.currentTimeMillis())

		then:
		thrown(IllegalArgumentException)

		where:
		value << [0, -1]
	}

	def "check statistics period resolved"() {
		setup:
		def timestamp = 200100
		properties.statisticsExportPeriod >> 100000

		expect:
		new StatisticsConfigurerImpl(properties).resolveTimestamp(timestamp) == 200000
	}
}
