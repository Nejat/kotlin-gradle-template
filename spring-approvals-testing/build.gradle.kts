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

dependencies {

    val approvalTestsVersion: String by extra

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.approvaltests:approvaltests:$approvalTestsVersion")
}

tasks {
    getByName<Jar>("jar") {
        enabled = true
    }
}