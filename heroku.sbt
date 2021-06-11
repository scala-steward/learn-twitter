Compile / herokuAppName :=
  Map(
    ("preview", "ahlers-learn-twitter-preview"),
    ("public", "ahlers-learn-twitter-public"))
    .apply(sys.props.getOrElse("stage", "preview"))

Compile / herokuSkipSubProjects := false
Compile / herokuJdkVersion := "15"
Compile / herokuProcessTypes += ("web", "target/universal/stage/bin/learn-twitter -- -http.port=:$PORT")
Compile / herokuBuildpacks += " https://github.com/DataDog/heroku-buildpack-datadog.git"

/**
 * {{{
 * heroku config:add --app=ahlers-learn-twitter-preview DD_AGENT_MAJOR_VERSION=7
 * heroku config:add --app=ahlers-learn-twitter-preview DD_API_KEY=4e7b17ba3ce1233fa643d010b4914e9b
 * heroku config:add --app=ahlers-learn-twitter-preview DD_SITE=datadoghq.com
 * }}}
 *
 * @see [[https://app.datadoghq.com/signup/agent#heroku]]
 */
