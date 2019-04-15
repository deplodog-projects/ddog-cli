import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.commonDependencies() {
    dependencies {
        "compileOnly"("com.google.code.findbugs:jsr305:${Libs.findbugsJsr305}")

        "compileOnly"("org.projectlombok:lombok:${Libs.lombok}")
        "annotationProcessor"("org.projectlombok:lombok:${Libs.lombok}")

        "testCompileOnly"("org.projectlombok:lombok:${Libs.lombok}")
        "testAnnotationProcessor"("org.projectlombok:lombok:${Libs.lombok}")

        "testCompile"("org.mockito:mockito-core:${Libs.mockito}")

        "testImplementation"("org.junit.jupiter:junit-jupiter-api:${Libs.jupiter}")
        "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:${Libs.jupiter}")
    }
}
