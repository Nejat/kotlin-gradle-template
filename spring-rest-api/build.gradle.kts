import org.springframework.boot.gradle.tasks.bundling.BootJar

version = "1.0-SNAPSHOT"

buildscript {

    val springBootVersion: String by extra

    dependencies {

        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    }
}

plugins {

    val springBootVersion: String by extra
    val springDependencyVersion: String by extra

    id("kotlin-spring")
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version springDependencyVersion
}

springBoot {
    mainClassName = "$group.spring.rest.api.SpringRestApiApplicationKt"
}

dependencies {

    val swaggerVersion: String by extra

    implementation("org.springframework.boot:spring-boot-starter-data-rest")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("io.springfox:springfox-swagger2:$swaggerVersion")
    implementation("io.springfox:springfox-swagger-ui:$swaggerVersion")

    implementation(project(":common-library"))
}

tasks {
    getByName<BootJar>("bootJar") {
        launchScript {
            properties(
                mapOf(
                    "logFilename" to "app.log"
                )
            )
        }
    }
}