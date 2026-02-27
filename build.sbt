val scala3Version = "3.8.2"

lazy val pgVersion = "42.7.10"
lazy val slickVersion = "3.6.1"
lazy val root = project
  .in(file("."))
  .settings(
    organization := "com.mhunt429",
    name := "cortado-db",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    publishTo := Some("GitHub Package Registry" at "https://maven.pkg.github.com/mhunt429/cortado-db"),
    credentials += Credentials(
      "GitHub Package Registry",
      "maven.pkg.github.com",
      "mhunt429",
      System.getenv("GITHUB_TOKEN")
    ),

    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % slickVersion,
      "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
      "com.typesafe.slick" %% "slick-codegen" % slickVersion,
      "org.flywaydb" % "flyway-core" % "12.0.3",
      "org.flywaydb" % "flyway-database-postgresql" % "12.0.3",
      "org.postgresql" % "postgresql" % pgVersion,

    )

  )
