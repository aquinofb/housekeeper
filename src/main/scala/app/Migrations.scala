package app

import db.CoreDatabase
import org.flywaydb.core.{Flyway => CoreFlyway}

object Migrations {
  def run: Boolean = {
    Flyway(None).migrate()
    true
  }
}

object Flyway {
  def apply(databaseName: Option[String]): CoreFlyway = {
    val flyway = new CoreFlyway
    val settings = CoreDatabase.settings(databaseName)

    flyway.setDataSource(settings.url, settings.user, settings.password)
    flyway.setSchemas(databaseName.getOrElse(settings.dbName))
    flyway
  }
}
