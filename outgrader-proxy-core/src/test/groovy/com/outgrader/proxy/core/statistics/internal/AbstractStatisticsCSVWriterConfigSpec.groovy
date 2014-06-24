package com.outgrader.proxy.core.statistics.internal

import java.text.SimpleDateFormat

import org.gerzog.jstataggr.writers.csv.ICSVWriterConfig

import spock.lang.Specification

import com.outgrader.proxy.core.statistics.internal.AbstractStatisticsCSVWriterConfig;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class AbstractStatisticsCSVWriterConfigSpec extends Specification {

	static final TEMP_DIR = System.properties['java.io.tmpdir']

	static final STATISTICS_NAME = 'statistics'

	ICSVWriterConfig validConfig = Spy(AbstractStatisticsCSVWriterConfig, constructorArgs: [TEMP_DIR])

	ICSVWriterConfig invalidConfig = Spy(AbstractStatisticsCSVWriterConfig, constructorArgs: [null])

	def statisticsData = Spy(AbstractStatisticsCollector)

	def timestamp = System.currentTimeMillis()

	def setup() {
		statisticsData.getTimestamp() >> timestamp
	}

	def "check file name for config without statistics export directory"() {
		when:
		invalidConfig.getFilename(STATISTICS_NAME, statisticsData)

		then:
		thrown(NullPointerException)
	}

	def "check file name for statistics data without timestamp property"() {
		when:
		validConfig.getFilename(STATISTICS_NAME, new Object())

		then:
		thrown(RuntimeException)
	}

	def "check excluded fields"() {
		expect:
		validConfig.getExcludedFields() == ['timestamp']
	}

	def "check created filename"() {
		expect:
		validConfig.getFilename(STATISTICS_NAME, statisticsData) == "/tmp/statistics/${new SimpleDateFormat('yyyy-MM-dd HH:mm').format(new Date(timestamp))}"
	}
}
