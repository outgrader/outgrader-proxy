package com.outgrader.properties.impl.internal;

import static org.apache.commons.lang3.Validate.notNull;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.FileConfiguration;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;
import org.apache.commons.configuration.event.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.outgrader.properties.impl.IPropertySource;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class AbstractPropertiesImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPropertiesImpl.class);

	private Configuration configuration;

	private IPropertySource propertySource;

	private boolean isChanged;

	private final String propertiesName;

	protected AbstractPropertiesImpl(final String propertiesName) {
		this.propertiesName = propertiesName;
	}

	protected void setPropertySource(final IPropertySource propertySource) {
		this.propertySource = propertySource;
	}

	protected Configuration getConfiguration() {
		return configuration;
	}

	@PostConstruct
	public void initialize() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("start initialize()");
		}

		LOGGER.info("Initializing properties %s", propertiesName);

		notNull(propertySource, "PropertySource was not initialized!");
		configuration = propertySource.getConfiguration();

		if (configuration instanceof EventSource) {
			((EventSource) configuration).addConfigurationListener(new ConfigurationListener() {

				@Override
				public void configurationChanged(final ConfigurationEvent event) {
					if (event.getType() == AbstractConfiguration.EVENT_SET_PROPERTY) {
						isChanged = true;
					}
				}
			});
		}
	}

	@PreDestroy
	public void cleanup() throws ConfigurationException {
		if ((configuration instanceof FileConfiguration) && isChanged) {
			((FileConfiguration) configuration).save();
		}
	}
}
