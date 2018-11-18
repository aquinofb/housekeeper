package db.tables

import java.util.UUID

import db.domain.Section
import slick.jdbc.PostgresProfile.api._

class SectionTable(tag: Tag) extends Table[Section](tag, "sections") {
  val id = column[Option[UUID]]("id", O.PrimaryKey)
  val name = column[String]("name")
  val order = column[Int]("order")

  def * = (id, name, order) <> ((Section.apply _).tupled, Section.unapply)
}
