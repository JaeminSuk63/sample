pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "sample"
include(":app")
include(":feature:launch")
include(":feature:base")
include(":domain:use_case")
include(":data:repository")
include(":data:api")
include(":data:db")
include(":domain:entity")
include(":common")
