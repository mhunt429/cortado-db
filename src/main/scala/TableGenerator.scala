import slick.codegen.SourceCodeGenerator
import slick.jdbc.PostgresProfile
import slick.model.Model

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
object TableGenerator {

  def generate(): Unit = {
    val db = PostgresProfile.api.Database.forURL(
      url = "jdbc:postgresql://localhost:55432/postgres",
      driver = "org.postgresql.Driver",
      user = "postgres",
      password = "postgres"
    )
    try
      val modelAction =
        PostgresProfile.createModel(None, ignoreInvalidDefaults = false)
      val model = Await.result(db.run(modelAction), Duration.Inf)
      val generator = new CustomSlickGenerator(model)
      generator.writeToFile("slick.jdbc.PostgresProfile", "src/main/scala", "com.mhunt429.cortado.db", "CortadoSchema", "CortadoSchema.scala")
    finally db.close()


  }
}


class CustomSlickGenerator(slickModel: Model)
  extends SourceCodeGenerator(slickModel):

  override def Table = new Table(_):
    override def Column = new Column(_):
      override def rawType: String =
        model.tpe match
          case "java.sql.Timestamp" => "java.time.Instant"
          case _ => super.rawType

  // Ensure java.time.Instant is imported in the generated file
  override def code =
    "import java.time.Instant" + "\n" + super.code
