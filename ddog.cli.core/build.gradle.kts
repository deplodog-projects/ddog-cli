plugins {
    java
    id("org.javamodularity.moduleplugin") version Plugins.module
}

commonDependencies()
dependencies {
    compile("com.beust:jcommander:${Libs.jCommander}")
}
