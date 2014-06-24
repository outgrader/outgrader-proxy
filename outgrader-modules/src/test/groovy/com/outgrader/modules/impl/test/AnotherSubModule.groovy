package com.outgrader.modules.impl.test

import org.springframework.context.annotation.Import

import com.outgrader.modules.annotations.Module

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
@Module('another name')
@Import(TestModule.class)
class AnotherSubModule {
}
