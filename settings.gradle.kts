pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    jcenter() // Warning: this repository is going to shut down soon
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "Bouddica Client"
include(":app")
 