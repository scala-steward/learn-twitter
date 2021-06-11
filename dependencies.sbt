//ThisBuild / scalaVersion := "3.0.0"
ThisBuild / scalaVersion := "2.13.6"

libraryDependencies ++=
  "ch.qos.logback" % "logback-classic" % "1.2.3" ::
    //"com.datadoghq" % "dd-finagle" % "0.2.3" ::
    Nil

libraryDependencies ++=
  ("com.twitter" %% "finatra-http-server" % "21.5.0" ::
    "com.twitter" %% "inject-logback" % "21.5.0" ::
    "com.twitter" %% "inject-server" % "21.5.0" ::
    "com.twitter" %% "inject-utils" % "21.5.0" ::
    "com.twitter" %% "twitter-server-logback-classic" % "21.5.0" ::
    Nil)
    .map(_
      .cross(CrossVersion.for3Use2_13))

libraryDependencies ++=
  (("com.twitter" %% "finatra-http-server" % "21.5.0" % Test).classifier("tests") ::
    ("com.twitter" %% "inject-server" % "21.5.0" % Test).classifier("tests") ::
    ("com.twitter" %% "inject-app" % "21.5.0" % Test).classifier("tests") ::
    ("com.twitter" %% "inject-core" % "21.5.0" % Test).classifier("tests") ::
    ("com.twitter" %% "inject-modules" % "21.5.0" % Test).classifier("tests") ::
    Nil)
    .map(_
      .cross(CrossVersion.for3Use2_13))
