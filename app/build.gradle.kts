plugins {
    id("com.android.application")
}

android {
    namespace = "fr.univparis8.etud.hydratereminder"
    compileSdk = 34

    defaultConfig {
        applicationId = "fr.univparis8.etud.hydratereminder"
        minSdk = 30
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

    }
        buildFeatures{
          viewBinding = true
         }
    buildToolsVersion = "33.0.1"
}

dependencies {

    implementation("androidx.fragment:fragment:1.6.2")
    debugImplementation("androidx.fragment:fragment-testing:1.6.2")
    implementation("androidx.activity:activity:1.8.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.gridlayout:gridlayout:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation("com.github.orbitalsonic:Water-Wave-Animation-Android:1.0.0")
    implementation("com.github.john990:WaveView:v0.9")
}