package com.outgrader.modules.impl.mixin.version;

import java.text.MessageFormat;

import com.outgrader.modules.IVersionedModule;
import com.outgrader.properties.IProperties;
import com.outgrader.properties.impl.internal.AbstractPropertiesImpl;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class VersionProperties extends AbstractPropertiesImpl implements IProperties, IVersionedModule {

	private static final String PROPERTIES_SOURCE_NAME = "{0}-version.properties";

	private static final String PROPERTIES_NAME = "{0}-version-properties";

	private static final String VERSION_PROPERTY = "outgrader.module.version";

	private static final String BUILD_DATE_PROPERTY = "outgrader.module.build_date";

	public VersionProperties(final String moduleName) {
		super(MessageFormat.format(PROPERTIES_NAME, moduleName));

		setPropertySource(new VersionPropertiesSource(MessageFormat.format(PROPERTIES_SOURCE_NAME, moduleName)));

		initialize();
	}

	@Override
	public String getVersion() {
		return getConfiguration().getString(VERSION_PROPERTY);
	}

	@Override
	public String getBuildDate() {
		return getConfiguration().getString(BUILD_DATE_PROPERTY);
	}

}
