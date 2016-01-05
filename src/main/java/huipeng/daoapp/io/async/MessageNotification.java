package huipeng.daoapp.io.async;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import huipeng.daoapp.io.service.MessageService;

@Component
public class MessageNotification {

  @Autowired
  private MessageService messageService;

  @EventListener
  public void processMessageEvent(MessageEvent event) throws IOException {
    messageService.somniloquy(event.getMessage());
  }
}
