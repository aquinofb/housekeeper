package db.tables

import java.util.UUID

import db.domain.Category
import slick.jdbc.PostgresProfile.api._

class CategoryTable(tag: Tag) extends Table[Category](tag, "categories") {
  val id = column[Option[UUID]]("id", O.PrimaryKey)
  val name = column[String]("name")

  override def * = (id, name) <> ((Category.apply _).tupled, Category.unapply)
}
