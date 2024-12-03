
plugins {
    id("buildlogic.kotlin-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":libs"))
}

application {
    // Define the main class for the application.
    mainClass = "advent.ofcode.day3.MainKt"
}
