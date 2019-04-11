import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.commonDependencies() {
    dependencies {
        "compileOnly"("com.google.code.findbugs:jsr305:${Libs.findbugsJsr305}")

        "testCompile"("org.mockito:mockito-core:${Libs.mockito}")

        "testImplementation"("org.junit.jupiter:junit-jupiter-api:${Libs.jupiter}")
        "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:${Libs.jupiter}")
    }
}
