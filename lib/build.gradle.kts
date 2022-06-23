plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    `java-library`
}

repositories {
    mavenCentral()
}
tasks.jar {
    manifest {
        attributes(mapOf("Implementation-Title" to rootProject.name,
            "Implementation-Version" to project.version))
    }
    archiveBaseName.set(rootProject.name)
}

group = "nl.rijksoverheid.minienw.travelvalidation"
version = "0.0.3-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    //Open API doc
    implementation("io.swagger:swagger-annotations:1.6.6")

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:30.1.1-jre")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    //api("org.apache.commons:commons-math3:3.6.1")

    implementation ("com.google.code.gson:gson:2.9.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.6.8")
}
