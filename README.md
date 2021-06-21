# Learn Twitter

A personal sandbox project for getting familiar with Twitter's technology stack (_e.g._, [Finatra][github-finatra], [Finagle][github-finagle]).

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

[github-finatra]: https://github.com/twitter/finatra
[github-finagle]: https://github.com/twitter/finagle
[github-sbt-revolver]: https://github.com/spray/sbt-revolver
