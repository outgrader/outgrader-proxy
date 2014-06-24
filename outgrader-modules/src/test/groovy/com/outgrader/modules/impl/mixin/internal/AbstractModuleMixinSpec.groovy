package com.outgrader.modules.impl.mixin.internal;

import spock.lang.Specification


/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class AbstractModuleMixinSpec extends Specification {

	AbstractModuleMixin<Object> mixin = Spy(AbstractModuleMixin)

	Object object = Mock(Object)

	Object instance = Mock(Object)

	def setup() {
		mixin.getThis() >> instance
	}

	def "check object was created when cache is empty"() {
		when:
		def result = mixin.get()

		then:
		1 * mixin.createObject(instance) >> object
		result == object
	}

	def "check object was created only once for one inctance"() {
		when:
		def result1 = mixin.get()
		def result2 = mixin.get()

		then:
		1 * mixin.createObject(instance) >> object
		result1 == result2
		result2 == object
	}
}
