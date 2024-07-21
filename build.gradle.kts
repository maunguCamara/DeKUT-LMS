// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.5.0" apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
}
buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url= uri("https://jitpack.io")  }
        maven {
            url = uri("https://maven.google.com")
        }
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.0.4")
        classpath ("com.google.gms:google-services:4.3.10")
    }
}

