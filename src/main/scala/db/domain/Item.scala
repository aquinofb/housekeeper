package db.domain

import java.util.UUID

case class Item(
  id: Option[UUID] = None,
  quantity: Int,
  size: Int,
  unitOfVolume: String,
  orderId: UUID,
  productId: UUID
)
