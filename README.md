## Cortado DB Library

This project is a library containing the Slick data model for the Cortado database. It is automatically generated from the database schema and hosted on GitHub Packages.

### Usage in other projects

To use this library in another sbt project, you need to configure your `build.sbt` to include the GitHub Package Registry and provide credentials.

1.  **Add the resolver and dependency to `build.sbt`**:

    ```scala
    resolvers += "GitHub Package Registry" at "https://maven.pkg.github.com/mhunt429/cortado-db"

    libraryDependencies += "com.mhunt429" %% "cortado-db" % "0.1.0-SNAPSHOT"
    ```

2.  **Provide GitHub Credentials**:
    You need a GitHub Personal Access Token (PAT) with `read:packages` scope. You can provide it via an environment variable `GITHUB_TOKEN` or by creating a `~/.sbt/1.0/github.sbt` file:

    ```scala
    credentials += Credentials(
      "GitHub Package Registry",
      "maven.pkg.github.com",
      "YOUR_GITHUB_USERNAME",
      "YOUR_GITHUB_TOKEN"
    )
    ```

### Generating the Schema

To regenerate the `CortadoSchema.scala` file from a running database:

```bash
sbt run
```

The generated file will be located at `src/main/scala/com/mhunt429/cortado/db/CortadoSchema.scala`.

### Publishing to GitHub Packages

This project uses GitHub Actions to automatically publish new versions of the library to GitHub Packages on every push to the `main` branch.

To manually publish a new version:

1.  Ensure you have `GITHUB_TOKEN` set in your environment with `write:packages` scope.
2.  Run:
    ```bash
    sbt publish
    ```
