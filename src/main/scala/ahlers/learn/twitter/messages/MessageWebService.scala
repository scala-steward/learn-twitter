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

  get("/messages/:id") { (webGetRequest: MessageWebGetRequest) =>
    messageService
      .getMessage(MessageGetRequest(webGetRequest.id))
      .map(_
        .into[MessageWebGetResponse]
        .transform)
      .handle {
        case MessageNotFoundException(id) =>
          throw response
            .notFound(s"""Couldn't find message with id. "$id".""")
            .toException
      }
  }

  post("/messages") { (webPostRequest: MessageWebPostRequest) =>
    messageService
      .createMessage(webPostRequest
        .into[MessageCreateRequest]
        .transform)
      .map(_
        .into[MessageWebPostResponse]
        .transform)
      .map(webPostResponse =>
        response
          .created(webPostResponse)
          .location(s"/messages/${webPostResponse.id}"))
  }

}
