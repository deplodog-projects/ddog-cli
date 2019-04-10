plugins {
    java
}

allprojects {
    group = "com.deplodog"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        jcenter()
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
