package com.nexivo.tests.spring.approvals.testsing

import com.nexivo.spring.approvals.testing.Widget
import org.approvaltests.Approvals
import org.approvaltests.reporters.DiffReporter
import org.approvaltests.reporters.UseReporter
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@UseReporter(DiffReporter::class)
class WidgetTests {

    @Test
    fun widgets_tested () {

        val sut = Widget(21.0)

        Approvals.verify(sut)
    }
}