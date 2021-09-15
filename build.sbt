name := "UI_UT_Assign_Saurabh"

version := "0.1"

scalaVersion := "2.13.6"

lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test
lazy val mockitoScala = "org.mockito" %% "mockito-scala" % "1.16.15" % Test

lazy val Question_1 = project.in(file("Question_1"))
  .settings(
    libraryDependencies += scalaTest
  )

lazy val Question_2 = project.in(file("Question_2"))
  .settings(
    libraryDependencies += scalaTest
  )

lazy val Question_3 = project.in(file("Question_3"))
  .settings(
    libraryDependencies ++= Seq(
      scalaTest,
      mockitoScala
    )
  )
lazy val root = project.in(file(".")).aggregate(Question_1,Question_2,Question_3)