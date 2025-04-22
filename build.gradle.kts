plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "ifmo.se"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.5")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "ifmo.se.Main"
    }
}


tasks.test {

}
