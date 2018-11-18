package db.domain

import java.util.UUID

case class Category(id: Option[UUID] = None, name: String)