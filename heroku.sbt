Compile / herokuAppName :=
  Map(
    ("preview", "ahlers-learn-twitter-preview"),
    ("public", "ahlers-learn-twitter-public"))
    .apply(sys.props.getOrElse("stage", "preview"))

Compile / herokuSkipSubProjects := false
Compile / herokuJdkVersion := "15"
Compile / herokuProcessTypes += ("web", "target/universal/stage/bin/learn-twitter -- -http.port=:$PORT")
Compile / herokuBuildpacks += " https://github.com/DataDog/heroku-buildpack-datadog.git"
