import com.mhunt429.cortado.db.MigrationRunner

@main def run(): Unit = {
  MigrationRunner.runMigrations()
  TableGenerator.generate()
}
