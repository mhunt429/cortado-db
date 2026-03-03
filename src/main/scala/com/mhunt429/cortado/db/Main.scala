package com.mhunt429.cortado.db

import com.mhunt429.cortado.db.CortadoDb

@main def run(): Unit = {
  CortadoDb.runMigrations()
  TableGenerator.generate()
}
