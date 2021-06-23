package ahlers.learn.twitter.messages

import com.twitter.finatra.http.Controller

/**
 * @since June 04, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
class MessageController()
  extends Controller {

  get("/messages/:id") { (request: MessageGetRequest) =>
    import request.id
    response
      .ok(MessageGetResponse(id))
      .location(id)
  }

}
