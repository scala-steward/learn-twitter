package ahlers.learn.twitter.messages

import com.twitter.inject.TwitterModule

import javax.inject.Singleton

/**
 * @since July 08, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
object MessageServiceInMemoryModule extends TwitterModule {
  override def configure() =
    bind[MessageService]
      .to[MessageServiceInMemory]
      .in[Singleton]()
}
