package ahlers.learn.twitter.messages

import ahlers.learn.twitter.LearnTwitterHttpServer
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.TestMixin
import com.twitter.inject.server.FeatureTestMixin
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck.{ Arbitrary, Gen, ScalacheckShapeless }
import com.softwaremill.diffx.generic.auto._
import com.softwaremill.diffx.scalatest.DiffMatcher._
import com.twitter.util.Future
import org.scalamock.scalatest.MockFactory
import io.circe.Json
import io.circe.syntax._

/**
 * @since July 07, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
object MessageWebControllerTest {

  implicit val arbMessageId: Arbitrary[MessageId] =
    Arbitrary(Gen.identifier
      .map(MessageId(_)))

  implicit val arbMessageBody: Arbitrary[MessageBody] =
    Arbitrary(Gen.nonEmptyListOf(Gen.identifier)
      .map(_
        .mkString(" ")
        .take(10)
        .trim())
      .map(MessageBody(_)))

}

class MessageWebControllerTest
  extends AnyWordSpec
    with TestMixin
    with FeatureTestMixin
    with MockFactory {

  import MessageWebControllerTest._

  val messageService: MessageService = mock[MessageService]

  val learnTwitterServer = new LearnTwitterHttpServer

  override val server =
    new EmbeddedHttpServer(
      learnTwitterServer,
      disableTestLogging = true)
      .bind[MessageService].toInstance(messageService)

  "GET /messages/:id" in {
    import ScalaCheckPropertyChecks._
    import ScalacheckShapeless._

    forAll { (webGetRequest: MessageWebGetRequest) =>
      val path = "/messages/%s".format(webGetRequest.id)

      val webGetResponse =
        MessageWebGetResponse(
          webGetRequest.id)

      server
        .httpGetJson[MessageWebGetResponse](
          path = path)
        .should(matchTo(webGetResponse))
    }
  }

  "POST /messages" in {
    import ScalaCheckPropertyChecks._
    import ScalacheckShapeless._

    forAll { (webPostRequest: MessageWebPostRequest) =>
      (messageService.createMessage _)
        .expects(*)
        .returns(Future(MessageCreateResponse(
          MessageId("random"),
          webPostRequest.body)))

      val path = "/messages"
      val postBody =
        Json.obj(
          "body" -> Json.fromString(webPostRequest.body.toText))
          .toString()

      val webPostResponse =
        MessageWebPostResponse(
          MessageId("random"),
          webPostRequest.body)

      server
        .httpPostJson[MessageWebPostResponse](
          path = path,
          postBody = postBody)
        .should(matchTo(webPostResponse))
    }
  }

}
