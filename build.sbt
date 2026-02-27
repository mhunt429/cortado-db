val scala3Version = "3.8.2"

lazy val pgVersion = "42.7.10"
lazy val slickVersion = "3.6.1"
lazy val root = project
  .in(file("."))
  .settings(
    name := "cortado-db",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % slickVersion,
      "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
      "com.typesafe.slick" %% "slick-codegen" % slickVersion,
      "org.flywaydb" % "flyway-core" % "12.0.3",
      "org.flywaydb" % "flyway-database-postgresql" % "12.0.3",
      "org.postgresql" % "postgresql" % pgVersion,

    )

  )
