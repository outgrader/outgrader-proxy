package com.outgrader.modules.impl.mixin

import spock.lang.Specification

import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixin

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
abstract class ModuleMixinSpecHelper extends Specification {

	def getMixin(final def instance) {
		def result = Spy(mixinClass())

		result.getThis() >> instance


		result
	}

	abstract Class<? extends AbstractModuleMixin> mixinClass()
}
