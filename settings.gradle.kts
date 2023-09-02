rootProject.name = "My-Libs-Deps-Java"
include("Vertx-Config-Yml")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val vertxVersion = "4.4.5"
            library("vertx-core", "io.vertx:vertx-core:$vertxVersion")
            library("vertx-config", "io.vertx:vertx-config:$vertxVersion")

            val junitVersion = "5.9.2"
            library("junit-bom", "org.junit:junit-bom:$junitVersion")

            library("snake-yaml", "org.yaml:snakeyaml:2.0")
        }
    }
}
