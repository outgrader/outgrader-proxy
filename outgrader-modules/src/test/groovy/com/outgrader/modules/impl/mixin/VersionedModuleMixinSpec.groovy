package com.outgrader.modules.impl.mixin

import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixin
import com.outgrader.modules.impl.test.SubModule

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class VersionedModuleMixinSpec extends ModuleMixinSpecHelper {

	def "check version of module"() {
		setup:
		def mixin = getMixin(new SubModule())

		when:
		def version = mixin.version
		def buildDate = mixin.buildDate

		then:
		version == '0.0.1-SNAPSHOT'
		buildDate == '24.06.2014 12:30'
	}

	@Override
	public Class<? extends AbstractModuleMixin> mixinClass() {
		VersionedModuleMixin
	}
}
