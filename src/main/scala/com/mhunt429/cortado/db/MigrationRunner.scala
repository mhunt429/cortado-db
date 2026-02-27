package com.mhunt429.cortado.db

import org.flywaydb.core.Flyway
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.PostgresProfile

object MigrationRunner {
  val profile           = PostgresProfile
  lazy val db: Database = Database.forConfig("database.db")

  private def flyway: Flyway = Flyway
    .configure()
    .cleanDisabled(false)
    .outOfOrder(true)
    .dataSource(
      db.source.asInstanceOf[slick.jdbc.hikaricp.HikariCPJdbcDataSource].ds
    )
    .load()

  def runMigrations(): Unit =
    flyway.migrate()

  def reloadMigrations(): Unit = {
    flyway.clean()
    runMigrations()
  }
}
