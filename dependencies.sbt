ThisBuild / scalaVersion := "3.0.0"

libraryDependencies ++=
  ("com.twitter" %% "finatra-http-server" % "21.5.0" ::
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
