package huipeng.daoapp.io.service;

public interface MessageService {
  void say(String message);

  void asyncSay(String message);
}
