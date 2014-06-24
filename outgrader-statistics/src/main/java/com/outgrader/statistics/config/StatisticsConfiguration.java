package com.outgrader.statistics.config;

import org.gerzog.jstataggr.IStatisticsManager;
import org.gerzog.jstataggr.core.expressions.IExpressionHandler;
import org.gerzog.jstataggr.core.manager.impl.StatisticsManagerImpl;
import org.gerzog.jstataggr.expressions.spel.SpelExpressionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
@Configuration
public class StatisticsConfiguration {

	@Bean
	public IExpressionHandler expressionHandler() {
		return new SpelExpressionHandler();
	}

	@Bean
	public IStatisticsManager statisticsManager() {
		return new StatisticsManagerImpl(expressionHandler());
	}
}
