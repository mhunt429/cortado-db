## Cortado DB Library

This project is a library containing the Slick data model for the Cortado database. It is automatically generated from the database schema and hosted on GitHub Packages.

### Usage in other projects

To use this library in another sbt project, you need to configure your `build.sbt` to include the GitHub Package Registry and provide credentials.

1.  **Add the resolver and dependency to `build.sbt`**:

    ```scala
    resolvers += "GitHub Package Registry" at "https://maven.pkg.github.com/mhunt429/cortado-db"

    libraryDependencies += "com.mhunt429" %% "cortado-db" % "0.1.0" // Check GitHub for the latest version
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

### Running Tests

Before checking in code, it is highly recommended to run the Flyway migration tests to ensure that your schema changes are valid and don't break existing migrations.

To run the sanity check:

```bash
sbt test
```

This will:
1.  Read the test configuration from `src/test/resources/application.conf`.
2.  Clean the database (drop all objects).
3.  Run all migrations from `src/main/resources/db/migration/`.
4.  Verify that the schema is correctly applied.

Note: Ensure you have a PostgreSQL instance running as specified in the test `application.conf` (default: `localhost:65432`).

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
