package com.outgrader.modules.impl.mixin.internal;

import spock.lang.Specification


/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
abstract class AbstractModuleMixinSpec extends Specification {

	def getMixin(final def instance) {
		def result = Spy(mixinClass())

		result.getThis() >> instance


		result
	}

	abstract Class<? extends AbstractModuleMixin> mixinClass()
}
