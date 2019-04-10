plugins {
    java
    application
    id("org.beryx.jlink") version "2.9.4"
}

application {
    mainClassName = "com.deplodog.ddog.CliApplication"
    applicationName = "ddog"
}

commonDependencies()
dependencies {
    implementation(project(":ddog-cli-core"))
    implementation("com.beust:jcommander:${Dep.jCommander}")
}

//buildscript {
//    repositories {
//        maven {
//            url = uri("https://plugins.gradle.org/m2/")
//        }
//    }
//    dependencies {
//        classpath("org.beryx:badass-jlink-plugin:2.9.4")
//    }
//}