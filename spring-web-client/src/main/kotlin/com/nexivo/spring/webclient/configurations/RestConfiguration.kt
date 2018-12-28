package com.nexivo.spring.webclient.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class RestConfiguration {

    @Bean
    fun restTemplate (): RestTemplate = RestTemplate()
}