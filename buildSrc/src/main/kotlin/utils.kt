import org.gradle.api.Project

import org.gradle.kotlin.dsl.*

fun Project.commonDependencies() {
    dependencies {
        "compileOnly"("com.google.code.findbugs:jsr305:${Dep.findbugsJsr305}")

        "compileOnly"("org.projectlombok:lombok:${Dep.lombok}")
        "testCompileOnly"("org.projectlombok:lombok:${Dep.lombok}")
        "annotationProcessor"("org.projectlombok:lombok:${Dep.lombok}")
        "testAnnotationProcessor"("org.projectlombok:lombok:${Dep.lombok}")

        "testCompile"("org.mockito:mockito-core:${Dep.mockito}")

        "testImplementation"("org.junit.jupiter:junit-jupiter-api:${Dep.jupiter}")
        "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:${Dep.jupiter}")
    }
}