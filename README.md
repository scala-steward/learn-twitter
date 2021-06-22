# Learn Twitter

A personal sandbox project for getting familiar with Twitter's technology stack (_e.g._, [Finatra][github-finatra], [Finagle][github-finagle]). Also includes deployment to hosting services (_e.g._, Heroku) and integration with monitoring services (_e.g._, [Datadog](https://datadog.com)).

## Development

Includes [sbt-revolver][github-sbt-revolver] for rapid server restarts on code changes:

```sbt
~reStart ahlers.learn.twitter.MessageHttpServerApp
```

Optionally, change the port number:

```sbt
~reStart ahlers.learn.twitter.MessageHttpServerApp -- -http.port=8080
```

Terminate the server process with:

```sbt
reStop
```

## Deployment

### Heroku

Uses [sbt-heroku][github-sbt-heroku] for application configuration and deployment:

```sbt
deployHeroku
```

To choose a specific deployment stage:

```sbt
set Compile / herokuAppName := "ahlers-learn-twitter-preview"; deployHeroku
```

## Monitoring

### Datadog

Uses [Datadog's library for Finagle][github-datadog-datadog-finagle]. A work-in-progress, [I'm currently developing a fork which uses SBT to publish cross-built artifacts against Scala 2.12 and 2.13][github-micahelahlers-datadog-finagle].

## Acknowledgments

- Special thanks to [Joe Kutner][github-jkutner] for contributions to [kissaten/finatra-hello-world][github-kissaten-finatra-hello-world], which demonstrates how to deploy Finatra applications to Heroku.

[github-datadog-datadog-finagle]: https://github.com/DataDog/datadog-finagle
[github-micahelahlers-datadog-finagle]: https://github.com/michaelahlers/datadog-finagle
[github-finatra]: https://github.com/twitter/finatra
[github-finagle]: https://github.com/twitter/finagle
[github-sbt-revolver]: https://github.com/spray/sbt-revolver
[github-sbt-heroku]: https://github.com/heroku/sbt-heroku
[github-jkutner]: https://github.com/jkutner
[github-kissaten-finatra-hello-world]: https://github.com/kissaten/finatra-hello-world
