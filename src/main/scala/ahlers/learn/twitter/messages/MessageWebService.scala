package ahlers.learn.twitter.messages

import com.twitter.finatra.http.Controller
import io.scalaland.chimney.dsl._

import javax.inject.Inject

/**
 * @since June 04, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
class MessageWebService @Inject() (messageService: MessageService)
  extends Controller {

  get("/messages/:id") { (request: MessageWebGetRequest) =>
    import request.id
    response
      .ok(MessageWebGetResponse(id))
      .location(id)
  }

  post("/messages") { (request: MessageWebPostRequest) =>
    messageService
      .createMessage(request
        .into[MessageCreateRequest]
        .transform)
      .map(_
        .into[MessageWebPostResponse]
        .transform)
  }

}
