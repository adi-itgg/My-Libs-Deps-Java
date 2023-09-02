plugins {
    id("java")
}

group = "com.aitech.llc.yml"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(libs.vertx.core)
    compileOnly(libs.vertx.config)
    implementation(libs.snake.yaml)

    testImplementation(platform(libs.junit.bom))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}