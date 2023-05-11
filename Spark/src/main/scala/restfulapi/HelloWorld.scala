package restfulapi

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import scala.concurrent.ExecutionContextExecutor

object HelloWorld extends App {

  implicit val system: ActorSystem = ActorSystem("hello-world-api")
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  val route: Route = {
    path("hello") {
      get {
        complete("Hello, world!")
      }
    }
  }

  val bindingFuture = Http().newServerAt("localhost", 8080).bind(route)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  scala.io.StdIn.readLine()

  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())

}
