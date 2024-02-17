plugins {
    kotlin("jvm") version "1.9.22"
    application
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
}

group = "com.felipegandra"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

dependencies {
    implementation("io.ktor:ktor-client-core:2.3.8")
    implementation("io.ktor:ktor-client-cio:2.3.8")
    implementation ("ch.qos.logback:logback-classic:1.4.14")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.8")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.8")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.9.22")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")

    implementation("com.squareup.okhttp3:okhttp:4.12.0")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}