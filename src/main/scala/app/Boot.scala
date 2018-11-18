package app

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives.pathPrefix
import akka.http.scaladsl.server.{HttpApp, Route}
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import db.CoreDatabase
import db.CoreDatabase.Database

import scala.concurrent.ExecutionContext

object Boot extends HttpApp with App {
  implicit val system: ActorSystem = ActorSystem("housekeeper")
  implicit val materializer: ActorMaterializer = ActorMaterializer.create(system)
  implicit val executionContext: ExecutionContext = system.dispatcher

  Migrations.run

  implicit lazy val db: Database = CoreDatabase()
//  override protected def routes: Route = Router().routes

  def routes: Route =
    (pathPrefix("health") & pathEndOrSingleSlash) {
      get {
        complete("healthy")
      }
    }

  startServer(Config.server.host, Config.server.port)
}
