package ahlers.learn.twitter

import com.twitter.finagle.stats.{ LoadedStatsReceiver, StatsReceiver }
import com.twitter.inject.TwitterModule

/**
 * @since June 11, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
object MessageStatsReceiverModule extends TwitterModule {
  override def configure() =
    bind[StatsReceiver]
      .toInstance(LoadedStatsReceiver.scope("message"))
}
