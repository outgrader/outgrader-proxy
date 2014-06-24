package com.outgrader.proxy.core.statistics.internal;

import static org.apache.commons.lang3.Validate.notEmpty;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.gerzog.jstataggr.writers.csv.ICSVWriterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.outgrader.proxy.core.statistics.internal.AbstractStatisticsCSVWriterConfig;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public abstract class AbstractStatisticsCSVWriterConfig implements ICSVWriterConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractStatisticsCSVWriterConfig.class);

	private static final List<String> EXCLUDED_FIELDS = Arrays.asList("timestamp");

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

	private static final String FILENAME_FORMAT = "{0}" + File.separator + "{1}" + File.separator + "{2}";

	private final String statisticsExportDirectory;

	protected AbstractStatisticsCSVWriterConfig(final String statisticsExportDirectory) {
		this.statisticsExportDirectory = statisticsExportDirectory;
	}

	@Override
	public String getFilename(final String statisticsName, final Object statisticsData) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("start getFilename({}, {})", statisticsName, statisticsData);
		}
		notEmpty(statisticsExportDirectory, "Statistics Export directory cannot be null or empty");

		final String result = MessageFormat.format(FILENAME_FORMAT, statisticsExportDirectory, statisticsName,
				DateFormatUtils.format(getTimestamp(statisticsData), DATE_FORMAT));

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("finish getFilename() -> {}", result);
		}

		return result;
	}

	private long getTimestamp(final Object statisticsData) {
		try {
			final String timestamp = BeanUtils.getProperty(statisticsData, "timestamp");

			return Long.parseLong(timestamp);
		} catch (final NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			LOGGER.error("An error occured during computing timestamp property for statistics data <" + toString(statisticsData) + ">", e);

			throw new RuntimeException(e);
		}
	}

	private String toString(final Object statisticsData) {
		return ToStringBuilder.reflectionToString(statisticsData, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public List<String> getExcludedFields() {
		return EXCLUDED_FIELDS;
	}

}
