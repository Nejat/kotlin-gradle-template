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

    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation(project(":common-library"))

    val approvalTestsVersion: String by extra

    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.approvaltests:approvaltests:$approvalTestsVersion")

    val springBootVersion: String by extra

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")
}

tasks {
    getByName<Jar>("jar") {
        enabled = false
    }

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