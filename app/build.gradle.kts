import com.android.build.api.dsl.Packaging

plugins {
    id(Plugins.application)
    id(Plugins.android)
}

android {
    namespace = Config.packageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        @Suppress("UnstableApiUsage")
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    @Suppress("UnstableApiUsage")
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }
    packagingOptions {
        resources {
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
}

dependencies {
    // Basic
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.lifecycleKtx)
    implementation(Dependencies.Android.activityCompose)
    implementation(Dependencies.Compose.composeUi)
    implementation(Dependencies.Compose.composeGraphics)
    implementation(Dependencies.Compose.composePreviewTooling)
    implementation(Dependencies.Compose.composeMaterial3)
    implementation(Dependencies.Compose.composeMaterial)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.jUnitUi)
    androidTestImplementation(Dependencies.Test.espresso)
    debugImplementation(Dependencies.Compose.Debug.composeUiTooling)
    debugImplementation(Dependencies.Compose.Debug.composeUiTestManifest)
    // Navigation
    implementation(Dependencies.Navigation.navigationCompose)
    // Hilt
    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Hilt.compiler)
    implementation(Dependencies.Hilt.navigation)
}