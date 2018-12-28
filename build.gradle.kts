import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "1.0-SNAPSHOT"

buildscript {

    val kotlinVersion: String by extra

    dependencies {

        classpath(kotlin("gradle-plugin", kotlinVersion))
        classpath(kotlin("allopen", kotlinVersion))
        classpath(kotlin("noarg", kotlinVersion))
    }

    repositories {
        jcenter()
    }
}

plugins {

    val kotlinVersion: String by extra

    kotlin("jvm") version kotlinVersion
}

allprojects {

    group = "com.nexivo"

    repositories {
        jcenter()
    }
}

subprojects {

    buildscript {

        val kotlinVersion: String by extra

        dependencies {

            classpath(kotlin("gradle-plugin", kotlinVersion))
            classpath(kotlin("allopen", kotlinVersion))
            classpath(kotlin("noarg", kotlinVersion))
        }

        repositories {
            jcenter()
        }
    }

    apply {
        plugin("kotlin")
    }

    tasks {

        val javaTarget: String by extra

        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = javaTarget
            }
        }

        val gradleVersion: String by extra

        withType<Wrapper> {
            this.gradleVersion = gradleVersion
            this.distributionUrl = "https://services.gradle.org/distributions/gradle-$gradleVersion-all.zip"
        }

        val kotlinVersion: String by extra

        dependencies {
            compile(kotlin("stdlib-jdk8", kotlinVersion))
            compile(kotlin("reflect", kotlinVersion))
        }
    }
}
