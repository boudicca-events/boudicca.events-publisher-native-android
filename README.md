# Boudicca Android Client
Boudicca is an open-source Android project aiming to provide a seamless and feature-rich experience for its users. This README specifically covers the native Android client.

## Getting Started
### Prerequisites
- Android Studio installed
- Kotlin and Android development environment set up

### Build Configuration
Boudicca uses Gradle as its build system. The necessary plugins are included in the build.gradle file.

```groovy
plugins {
  id 'com.android.application'
  id 'kotlin-android'
  id 'kotlin-kapt'
  id 'dagger.hilt.android.plugin'
}
```

### Running the App
1. Open the project in Android Studio.
2. Connect an Android device or use an emulator.
3. Click on the "Run" button in Android Studio, or use the command ./gradlew installDebug in the terminal.

### Building the App
To build the Boudicca Android client, run the following command:

```bash
./gradlew build
```

The APK file will be generated in the app/build/outputs/apk directory.

### Testing
Boudicca uses JUnit for unit testing. To run the tests, use the following command:

```bash
./gradlew test
```

For instrumented tests, use:


```bash
./gradlew connectedAndroidTest
```

## Dependencies
Boudicca relies on several libraries and frameworks, including:

- Dagger Hilt for dependency injection
- Jetpack Compose for UI development
- Retrofit for network communication
- Coil for image loading
- Hilt Navigation Compose for navigation
- And more (see the dependencies block in build.gradle)

## License

Boudicca Android Client is licensed under the GNU General Public License v3.0. See the LICENSE file for details.

----

Feel free to contribute, report issues, or make suggestions to enhance the Boudicca Android client. Thank you for being part of the project!
