plugins {
    id("java")
}

group = "com.aitech.llc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform(libs.junit.bom))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "maven-publish")

    val javaVersion = "1.8"

    tasks.withType<JavaCompile> {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    tasks.withType<Jar> {
        enabled = true
    }

}
