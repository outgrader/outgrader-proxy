package com.outgrader.modules.impl.mixin

import com.outgrader.modules.annotations.Module
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixin
import com.outgrader.modules.impl.mixin.internal.AbstractModuleMixinSpec

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class NamedModuleMixinSpec extends AbstractModuleMixinSpec {

	@Module
	class Default {
	}

	@Module('name')
	class Named {
	}

	def "check name of class without annotation config"() {
		when:
		def name = getMixin(new Default()).getName()

		then:
		name == 'default'
	}

	def "check name of class with annotation config"() {
		when:
		def name = getMixin(new Named()).getName()

		then:
		name == 'name'
	}

	@Override
	public Class<? extends AbstractModuleMixin> mixinClass() {
		NamedModuleMixin
	}
}
