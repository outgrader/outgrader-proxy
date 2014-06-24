package com.outgrader.properties.impl.internal;

import static org.apache.commons.lang3.Validate.notNull;

import java.io.IOException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.outgrader.properties.impl.IPropertySource;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public abstract class AbstractResourcePropertySource implements IPropertySource {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractResourcePropertySourceSpec.class);

	private Configuration configuration;

	@Override
	public Configuration getConfiguration() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("start getConfiguration()");
		}

		if (configuration == null) {
			LOGGER.info("Initializing PropertySource");

			final Resource resource = getConfigurationResource();

			notNull(resource, "Properties resource cannot be null");

			try {
				configuration = createConfiguration(resource);
			} catch (final ConfigurationException | IOException e) {
				LOGGER.error("An error occured during initialization Properties Configuration from <" + resource + ">", e);

				throw new RuntimeException(e);
			}
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("finish getConfiguration() -> {}", configuration);
		}

		return configuration;
	}

	protected abstract Configuration createConfiguration(Resource resource) throws ConfigurationException, IOException;

	protected Resource getConfigurationResource() {
		LOGGER.info("Determining configuration file location");

		Resource result = null;

		for (final String locationCandidate : getLocationCandidates()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Check configuration file location at <{}>", locationCandidate);
			}

			result = new ClassPathResource(locationCandidate);

			if (result.exists()) {
				break;
			}

			result = null;
		}

		if (result != null) {
			LOGGER.info("Configuration file found at <{}>", result);
		} else {
			LOGGER.error("No configuration files found at locations <{}>", (Object[]) getLocationCandidates());
		}

		return result;
	}

	protected abstract String[] getLocationCandidates();

}
