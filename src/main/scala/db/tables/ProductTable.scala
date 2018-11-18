package db.tables

import java.util.UUID

import db.domain.Product
import slick.jdbc.PostgresProfile.api._

class ProductTable(tag: Tag) extends Table[Product](tag, "products") {
  val id = column[Option[UUID]]("id", O.PrimaryKey)
  val name = column[String]("names")
  val defaultSize = column[Int]("default_size")
  val defaultUnitOfVolume = column[String]("default_unit_of_volume")
  val categoryId = column[UUID]("category_id")

  def * = (id, name, defaultSize, defaultUnitOfVolume, categoryId) <> ((Product.apply _).tupled, Product.unapply)
}
