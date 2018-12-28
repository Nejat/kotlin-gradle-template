package com.nexivo.spring.webclient.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("client-properties")
class ClientProperties {

    var host: String = ""

    var endPoint : String = ""

    val url get(): String = "$host/$endPoint"
}