package com.outgrader.proxy.core.statistics.internal;

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

	public AbstractStatisticsCollector() {
		this.timestamp = System.currentTimeMillis();
	}

	public long getTimestamp() {
		return timestamp;
	}

}
