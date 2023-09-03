
group = "com.aitech.llc.yml"

dependencies {
    compileOnly(libs.vertx.core)
    compileOnly(libs.vertx.config)
    implementation(libs.snake.yaml)

    testImplementation(platform(libs.junit.bom))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<Jar> {
    enabled = true

    manifest {
        attributes["Implementation-Version"] = project.version
        attributes["Automatic-Module-Name"] = project.name
    }

    // archiveFileName.set("your-custom-jar-name.jar") // Optional: Set custom JAR file name

    from(sourceSets.main.get().output)

    into("META-INF/maven/${project.group}/${project.name}") {
        from(tasks.getByName("generatePomFileForMavenJavaPublication"))
        rename { it.replace("pom-default.xml", "pom.xml") }
    }
}