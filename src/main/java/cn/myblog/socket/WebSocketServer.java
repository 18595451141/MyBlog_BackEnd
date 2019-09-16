package cn.myblog.socket;

import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket/{User_accountNumber}")
@RestController
public class WebSocketServer {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static volatile int onlineCount = 0;
    //用来存放每个客户端对应的WebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("User_accountNumber") String User_accountNumber) {
        System.out.println("WebSocket连接成功 账号：" + User_accountNumber);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        System.out.println("WebSocket连接关闭 ");
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public String onMessage(String message) {
        System.out.println("接收到前端传递的参数包：" + message);
        return "后端反馈字符串336";
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
}
