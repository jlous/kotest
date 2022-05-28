plugins {
   id("kotlin-conventions")
}

kotlin {
   targets {
      jvm()
   }

   sourceSets {

      val jvmTest by getting {
         dependencies {
            implementation(project(Projects.Assertions.Core))
            implementation(project(Projects.JunitRunner))
         }
      }

      all {
         languageSettings.optIn("kotlin.time.ExperimentalTime")
         languageSettings.optIn("kotlin.experimental.ExperimentalTypeInference")
      }
   }
}
