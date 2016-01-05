package huipeng.daoapp.io.api;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import huipeng.daoapp.io.service.MessageService;

@RestController
public class MessageEndPoint {

  @Autowired
  private MessageService messageService;

  @RequestMapping(value = "/API/say/{message}", method = RequestMethod.GET,
      produces = "application/json; charset=UTF-8")
  public String say(@PathVariable String message) {
    messageService.say(message);
    messageService.asyncSay(message);
    return message;
  }

  @RequestMapping(value = "/API/call/{message}", method = RequestMethod.GET,
      produces = "application/json; charset=UTF-8")
  public Callable<String> call(@PathVariable String message) {
    messageService.say(message);
    return new Callable<String>() {
      @Override
      public String call() throws Exception {
        messageService.asyncSay(message);
        return message;
      }
    };
  }
}
