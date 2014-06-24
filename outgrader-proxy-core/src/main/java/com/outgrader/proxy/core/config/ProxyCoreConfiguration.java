package com.outgrader.proxy.core.config;

import org.gerzog.jstataggr.IStatisticsHandler;
import org.gerzog.jstataggr.IStatisticsManager;
import org.gerzog.jstataggr.core.impl.AsyncStatisticsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.outgrader.proxy.core.properties.IProxyProperties;
import com.outgrader.proxy.core.statistics.IStatisticsConfigurer;
import com.outgrader.proxy.core.statistics.impl.StatisticsConfigurerImpl;
import com.outgrader.statistics.config.StatisticsConfiguration;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
@Configuration
@Import(StatisticsConfiguration.class)
public class ProxyCoreConfiguration {

	@Autowired
	private IStatisticsManager statisticsManager;

	@Bean
	public IProxyProperties proxyProperties() {
		return null;
	}

	@Bean
	public IStatisticsHandler statistcsHandler() {
		return new AsyncStatisticsHandler(statisticsManager, proxyProperties().getStatisticsThreadNumber());
	}

	@Bean
	public IStatisticsConfigurer statisticsConfigurer() {
		return new StatisticsConfigurerImpl(proxyProperties());
	}

}
