package com.nexivo.spring.boot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootJarApplication

fun main(args: Array<String>) {
    runApplication<SpringBootJarApplication>(*args)
}