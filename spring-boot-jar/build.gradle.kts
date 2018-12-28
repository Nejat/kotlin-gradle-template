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
    mainClassName = "$group.spring.boot.SpringBootJarApplicationKt"
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter")

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