package huipeng.daoapp.io.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MessageEventPublisher implements ApplicationEventPublisherAware {
  private static final Logger logger = LoggerFactory.getLogger(MessageEventPublisher.class);
  private ApplicationEventPublisher publisher;

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.publisher = applicationEventPublisher;
  }

  public void sendMessage(String message) {
    MessageEvent event = new MessageEvent(this, message);
    logger.debug(new StringBuilder("Send Event").toString());
    publisher.publishEvent(event);
    logger.debug(new StringBuilder("Event Done").toString());
  }

  @Async
  public void asyncSendMessage(String message) {
    MessageEvent event = new MessageEvent(this, message);
    logger.debug(new StringBuilder("Send Async Event").toString());
    publisher.publishEvent(event);
    logger.debug(new StringBuilder("Async Event Done").toString());
  }
}
