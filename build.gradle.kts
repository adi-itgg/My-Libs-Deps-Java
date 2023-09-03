plugins {
    id("java")
    id("maven-publish")
}

group = "com.aitech.llc"
version = "1.0.0"

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

project("vertx-config-yml") {
    version = "1.0.0"
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "maven-publish")

    repositories {
        mavenCentral()
    }

    val javaVersion = "1.8"

    tasks.withType<JavaCompile> {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    configure<PublishingExtension> {
        publications {
            create<MavenPublication>("mavenJava") {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
                from(components["java"])
            }
        }
    }


    tasks.test {
        useJUnitPlatform()
    }
}