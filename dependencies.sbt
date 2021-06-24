resolvers += "JitPack".at("https://jitpack.io")

ThisBuild / scalaVersion := "2.13.6"

libraryDependencies ++=
  "ch.qos.logback" % "logback-classic" % "1.2.3" ::
    //"com.datadoghq" %% "dd-finagle" % "0.2.3" ::
    "com.github.michaelahlers" %% "datadog-finagle" % "0.2.4" ::
    Nil

libraryDependencies ++=
  ("com.twitter" %% "finatra-http-server" % "21.6.0" ::
    "com.twitter" %% "inject-logback" % "21.6.0" ::
    "com.twitter" %% "inject-server" % "21.6.0" ::
    "com.twitter" %% "inject-utils" % "21.6.0" ::
    "com.twitter" %% "twitter-server-logback-classic" % "21.6.0" ::
    Nil)
    .map(_
      .cross(CrossVersion.for3Use2_13))

libraryDependencies ++=
  (("com.twitter" %% "finatra-http-server" % "21.6.0" % Test).classifier("tests") ::
    ("com.twitter" %% "inject-server" % "21.6.0" % Test).classifier("tests") ::
    ("com.twitter" %% "inject-app" % "21.6.0" % Test).classifier("tests") ::
    ("com.twitter" %% "inject-core" % "21.6.0" % Test).classifier("tests") ::
    ("com.twitter" %% "inject-modules" % "21.6.0" % Test).classifier("tests") ::
    Nil)
    .map(_
      .cross(CrossVersion.for3Use2_13))

libraryDependencies ++=
  ("com.softwaremill.diffx" %% "diffx-scalatest" % "0.4.3" % Test ::
    "com.github.alexarchambault" %% "scalacheck-shapeless_1.15" % "1.3.0" % Test ::
    "org.scalacheck" %% "scalacheck" % "1.15.3" % Test ::
    "org.scalamock" %% "scalamock" % "5.1.0" % Test ::
    "org.scalatest" %% "scalatest" % "3.2.5" % Test ::
    Nil)
    .map(_
      .cross(CrossVersion.for3Use2_13))
