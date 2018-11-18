package db.domain

import java.sql.Date
import java.util.UUID

case class Order(
  id: Option[UUID] = None,
  date: Date,
  sectionId: UUID
)
