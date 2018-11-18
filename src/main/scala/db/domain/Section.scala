package db.domain

import java.util.UUID

case class Section(
  id: Option[UUID] = None,
  name: String,
  order: Int
)
