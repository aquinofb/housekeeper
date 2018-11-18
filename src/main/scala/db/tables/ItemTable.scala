package db.tables

import java.util.UUID

import db.domain.Item
import slick.jdbc.PostgresProfile.api._

class ItemTable(tag: Tag) extends Table[Item](tag, "items") {
  val id = column[Option[UUID]]("id", O.PrimaryKey)
  val quantity = column[Int]("quantity")
  val size = column[Int]("size")
  val unitOfVolume = column[String]("unit_of_volume")
  val orderId = column[UUID]("order_id")
  val productId = column[UUID]("product_id")

  def * = (id, quantity, size, unitOfVolume, orderId, productId) <> ((Item.apply _).tupled, Item.unapply)
}
