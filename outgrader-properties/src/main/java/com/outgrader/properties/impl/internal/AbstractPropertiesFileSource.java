package com.outgrader.properties.impl.internal;

import java.io.IOException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public abstract class AbstractPropertiesFileSource extends AbstractResourcePropertySource {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPropertiesFileSource.class);

	@Override
	protected Configuration createConfiguration(final Resource resource) throws ConfigurationException, IOException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("start createConfiguration({})", resource);
		}

		LOGGER.info("Creating Properties configuration for <{}>", resource);

		final Configuration result = new PropertiesConfiguration(resource.getFile());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("finish createConfiguration() -> {}", result);
		}

		return result;
	}
}
