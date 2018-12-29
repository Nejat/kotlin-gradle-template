package com.nexivo.tests.spring.boot

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.nexivo.spring.boot.settings.ApplicationSettings
import org.approvaltests.Approvals
import org.approvaltests.reporters.DiffReporter
import org.approvaltests.reporters.UseReporter
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [ApplicationSettings::class])
@UseReporter(DiffReporter::class)
class ApplicationSettingsDefaultProfileTests {

    @Autowired
    private lateinit var applicationSettings: ApplicationSettings

    private val mapper: ObjectMapper = ObjectMapper().registerKotlinModule()


    init {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
    }

    @Test
    fun test_application_settings_default_profile () {

        val json = mapper.writeValueAsString(applicationSettings)

        Approvals.verify(json)
    }
}

