plugins {
    id("java")
}

group = "ifmo.se"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.5")
}

tasks.test {

}
