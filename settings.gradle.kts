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
include(":feature:sample_ui")
include(":feature:sample_domain")
include(":data:repository")
include(":data:api")
include(":data:db")
include(":shared:entity")
