package com.nexivo.spring.rest.api.runners

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
@Suppress("unused")
internal class ServiceRunner: CommandLineRunner {

    override fun run(vararg args: String?) {

        var shutDown = false

        Runtime.getRuntime().addShutdownHook(Thread { shutDown = true })

        while (!shutDown) {
            Thread.sleep(100)
        }
    }
}