package com.nexivo.spring.boot.runners

import com.nexivo.common.Foo
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
@Suppress("unused")
internal class MainRunner: CommandLineRunner {

    override fun run(vararg args: String?) {
        println(Foo())
    }
}