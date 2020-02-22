import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server._
import akka.stream.ActorMaterializer
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.scaladsl._
import scala.concurrent.Await

object PingPongServer extends App {

  implicit val system: ActorSystem             = ActorSystem()
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val route =
    pathEndOrSingleSlash {
      post {
        extractRequest { req =>
          val result = req.entity.dataBytes.map(_.utf8String).runWith(Sink.head)
          onSuccess(result) { body =>
            println(s"Client input is '$body'")
            val res = body.toLowerCase match {
              case "ping" => "pong"
              case _      => body
            }
            complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, res))
          }
        }
      }
    } ~
    path("ping") {
        get {
            complete("pong")
        }
    }

  val host = "0.0.0.0"
  val port = sys.env.getOrElse("PORT", "8080").toInt
  Http().bindAndHandle(route, host, port)

  sys.addShutdownHook({
    import scala.concurrent.duration._
    Await.ready(system.terminate(), 30.seconds)
  })
}
