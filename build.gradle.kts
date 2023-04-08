plugins {
    id("java")
    id("application")
}

group = "cc.wybxc"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

application {
    mainClass.set("cc.wybxc.Main")
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "cc.wybxc.Main",
            "Class-Path" to configurations.compileClasspath.get().joinToString(" ") { it.name }
        )
    }
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
