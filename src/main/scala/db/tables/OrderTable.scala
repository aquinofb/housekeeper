package db.tables

import java.sql.Date
import java.util.UUID

import db.domain.Order
import slick.jdbc.PostgresProfile.api._

class OrderTable(tag: Tag) extends Table[Order](tag, "orders") {
  val id = column[Option[UUID]]("id", O.PrimaryKey)
  val date = column[Date]("date")
  val sectionId = column[UUID]("section_id")

  def * = (id, date, sectionId) <> ((Order.apply _).tupled, Order.unapply)
}
