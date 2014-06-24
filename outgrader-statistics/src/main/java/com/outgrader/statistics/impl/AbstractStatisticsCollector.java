package com.outgrader.statistics.impl;

import org.gerzog.jstataggr.annotations.Expression;
import org.gerzog.jstataggr.annotations.StatisticsKey;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public abstract class AbstractStatisticsCollector {

	@StatisticsKey
	@Expression("@statisticsConfigurer.resolveTimestamp(#this)")
	private final long timestamp;

	protected AbstractStatisticsCollector() {
		this.timestamp = System.currentTimeMillis();
	}

}
