package com.nexivo.spring.rest.api.controllers

import com.nexivo.common.Foo
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Suppress("unused")
@RestController
class JunkController {

    @GetMapping("/v1/api/foo")
    fun getFoo (): ResponseEntity<String> {

        return ResponseEntity(Foo().toString(), OK)
    }
}