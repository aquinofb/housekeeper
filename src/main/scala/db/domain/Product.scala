package db.domain

import java.util.UUID

case class Product(
  id: Option[UUID] = None,
  name: String,
  defaultSize: Int,
  DefaultUnitOfVolume: String,
  categoryId: UUID
)
