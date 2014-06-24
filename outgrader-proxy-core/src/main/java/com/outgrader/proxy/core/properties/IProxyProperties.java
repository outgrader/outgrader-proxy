package com.outgrader.proxy.core.properties;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public interface IProxyProperties {

	int getStatisticsExportPeriod();

	String getStatisticsExportDirectory();

	int getStatisticsThreadNumber();

}
