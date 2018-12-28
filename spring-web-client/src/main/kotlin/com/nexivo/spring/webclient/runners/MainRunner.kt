package com.nexivo.spring.webclient.runners

import com.nexivo.spring.webclient.properties.ClientProperties
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
@Suppress("unused")
internal class MainRunner(
    private val clientProperties: ClientProperties,
    private val restTemplate: RestTemplate
): CommandLineRunner {

    override fun run(vararg args: String?) {

        println(
            restTemplate.getForEntity<String>(clientProperties.url, String::class.java).body
        )
    }
}