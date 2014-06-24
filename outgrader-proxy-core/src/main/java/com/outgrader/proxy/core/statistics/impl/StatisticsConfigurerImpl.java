package com.outgrader.proxy.core.statistics.impl;

import static org.apache.commons.lang3.Validate.inclusiveBetween;

import com.outgrader.proxy.core.properties.IProxyProperties;
import com.outgrader.proxy.core.statistics.IStatisticsConfigurer;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class StatisticsConfigurerImpl implements IStatisticsConfigurer {

	private final long exportPeriod;

	public StatisticsConfigurerImpl(final IProxyProperties proxyProperties) {
		this.exportPeriod = proxyProperties.getStatisticsExportPeriod();
	}

	@Override
	public long resolveTimestamp(final long originalTimestamp) {
		inclusiveBetween(1, Long.MAX_VALUE, exportPeriod, "Statistics Export period should be positive value");

		final long offset = originalTimestamp % exportPeriod;

		return originalTimestamp - offset;
	}

}
