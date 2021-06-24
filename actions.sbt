ThisBuild / githubWorkflowJavaVersions :=
  "adopt@1.15" ::
    Nil

/**
 * Attempt to give access to my own repository's packages. 🤷🏻
 * @see [[https://github.com/djspiewak/sbt-github-packages#github-actions]]
 */
ThisBuild / githubWorkflowEnv += ("GITHUB_TOKEN", "${{ secrets.GITHUB_TOKEN }}")
