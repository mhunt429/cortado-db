package com.mhunt429.cortado.db

import org.scalatest.funsuite.AnyFunSuite
import java.sql.DriverManager
import com.typesafe.config.ConfigFactory

class FlywayMigrationTest extends AnyFunSuite {

  private val config = ConfigFactory.load()
  private val dbConfig = config.getConfig("database.db")
  private val dbUrl = dbConfig.getString("url")
  private val dbUser = dbConfig.getString("user")
  private val dbPassword = dbConfig.getString("password")

  test("Database should clean and migrate successfully using MigrationRunner") {
    // Perform Clean and Migration via MigrationRunner
    try {
      CortadoDb.reloadMigrations()
      info("Database reloaded (cleaned and migrated) successfully via MigrationRunner")
    } catch {
      case e: Exception => fail(s"Failed to reload database via MigrationRunner: ${e.getMessage}")
    }

    // Basic Smoke Test - Check if one of the tables exists (e.g., app_user)
    val conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)
    try {
      val metaData = conn.getMetaData
      val resultSet = metaData.getTables(null, null, "app_user", Array("TABLE"))
      assert(resultSet.next(), "Table 'app_user' should exist after migration")
    } finally {
      conn.close()
    }
  }
}
