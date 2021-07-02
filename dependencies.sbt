ThisBuild / scalaVersion := "2.13.6"

//resolvers += Resolver.githubPackages("michaelahlers", "datadog-finagle")
//resolvers += "michaelahlers/datadog-finagle".at("https://maven.pkg.github.com/michaelahlers/datadog-finagle")
resolvers += Resolver.url("Ahlers Consulting Artifacts (public)", url("https://ahlers-consulting-artifacts-public.s3.amazonaws.com/"))(Resolver.ivyStylePatterns)

libraryDependencies ++=
  "ch.qos.logback" % "logback-classic" % "1.2.3" ::
    "net.logstash.logback" % "logstash-logback-encoder" % "4.5.1" ::
    //"com.datadoghq" %% "dd-finagle" % "0.2.3" ::
    "com.datadoghq" %% "dd-finagle_21.6" % "0.2.9-SNAPSHOT" ::
    Nil

libraryDependencies ++=
  ("com.twitter" %% "finatra-http-server" % "21.6.0" ::
    "com.twitter" %% "inject-logback" % "21.6.0" ::
    "com.twitter" %% "inject-server" % "21.6.0" ::
    "com.twitter" %% "inject-slf4j" % "21.6.0" ::
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
  ("com.softwaremill.diffx" %% "diffx-scalatest" % "0.5.2" % Test ::
    "com.github.alexarchambault" %% "scalacheck-shapeless_1.15" % "1.3.0" % Test ::
    "org.scalacheck" %% "scalacheck" % "1.15.4" % Test ::
    "org.scalamock" %% "scalamock" % "5.1.0" % Test ::
    "org.scalatest" %% "scalatest" % "3.2.9" % Test ::
    Nil)
    .map(_
      .cross(CrossVersion.for3Use2_13))
