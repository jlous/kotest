plugins {
   id("kotest-jvm-conventions")
   id("kotest-publishing-conventions")
}

kotlin {
   sourceSets {

      val jvmMain by getting {
         dependencies {
            compileOnly(kotlin("stdlib"))
            implementation(kotlin("reflect"))
//            implementation(Libs.Kotlin.kotlinScriptRuntime)

            api(project(Projects.Common))
            // needed to compile against Spec
            // but runtime classes must be provided by modules using discovery
            compileOnly(project(Projects.Framework.api))

            // needed to scan the classpath for classes
            implementation(libs.classgraph)
         }
      }

      all {
         languageSettings.optIn("kotlin.time.ExperimentalTime")
         languageSettings.optIn("kotlin.experimental.ExperimentalTypeInference")
      }
   }
}
