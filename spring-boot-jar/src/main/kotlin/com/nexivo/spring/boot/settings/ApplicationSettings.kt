package com.nexivo.spring.boot.settings

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("app-settings")
@EnableConfigurationProperties(ApplicationSettings::class)
class ApplicationSettings {

    var number: Double = 0.0

    lateinit var string: String

    val map: MutableMap<String, SomePojo> = mutableMapOf()

    val list: MutableList<String> = mutableListOf()

    class SomePojo {

        lateinit var player1: String

        lateinit var player2: String

        lateinit var toy: String
    }
}