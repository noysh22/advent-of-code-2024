# Advent of code 2024 with Kotlin

## Build system

This project uses gradle as build system.

To build the project, run:

```shell
./gradlew build
```

To run each project, run:

```shell
./gradlew :dayX:run
```

## Structure

This project will contain a kotlin application for each day of advent,
so they can be run and tested separately, and add the folder name to the root `settings.gradle.kts` file.

For any shared code or libraries, add them to the libs folder.

## Shared dependencies
Shared dependencies are defined in the `buildSrc/src/main/kotlin/buildlogic.xxx.gradle.kts` files.
Use the right file depending on the type of dependency you want to add (application, library).
