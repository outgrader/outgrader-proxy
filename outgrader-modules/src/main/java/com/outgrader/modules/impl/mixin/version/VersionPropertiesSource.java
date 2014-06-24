package com.outgrader.modules.impl.mixin.version;

import com.outgrader.properties.impl.internal.AbstractPropertiesFileSource;

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
public class VersionPropertiesSource extends AbstractPropertiesFileSource {

	private final String[] locationCandidates;

	public VersionPropertiesSource(final String location) {
		this.locationCandidates = new String[] { location };
	}

	@Override
	protected String[] getLocationCandidates() {
		return locationCandidates;
	}
}
