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

/**
 * @since July 07, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
object MessageWebControllerTest {

  implicit val arbMessageId: Arbitrary[MessageId] =
    Arbitrary(Gen.identifier
      .map(MessageId(_)))

}

class MessageWebControllerTest
  extends AnyWordSpec
    with TestMixin
    with FeatureTestMixin {

  import MessageWebControllerTest._

  override val server =
    new EmbeddedHttpServer(
      new LearnTwitterHttpServer,
      disableTestLogging = true)

  "GET /messages/:id" in {
    import ScalaCheckPropertyChecks._
    import ScalacheckShapeless._

    forAll { (request: MessageWebGetRequest) =>
      val path = "/messages/%s".format(request.id)

      val response =
        MessageWebGetResponse(
          request.id)

      server
        .httpGetJson[MessageWebGetResponse](
          path = path)
        .should(matchTo(response))
    }

  }

}
