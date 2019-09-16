package cn.myblog.socket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/sunSocket")
@Component
public class SunWebSocket {

    /**
     * 记录在线链接数
     */
    private static int onLineNum = 0;

    /**
     * concurrent包的线程安全set，存放每个客户端连接对应的webSocket对象。
     */
    private static CopyOnWriteArraySet<SunWebSocket> webSocketSet = new CopyOnWriteArraySet<>();
    /**
     * 与某个客户端的会话，通过会话给客户端传递消息
     */
    private Session session;

    /**
     * 开启一个客户端对话连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        sendMsg("欢迎加入聊天室", session);
    }

    /**
     * 当连接断开时调用的方法
     *
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有人走了");
    }

    /**
     * 当有来自客户端的消息时
     *
     * @param msg
     * @param session
     */
    @OnMessage
    public void onMessage(String msg, Session session) {
        Map<String, String> map = new HashMap<>();
        map.put("ip", session.getId());
        map.put("msg", msg);
        for (SunWebSocket sunWebSocket : webSocketSet) {
            try {
                sunWebSocket.session.getBasicRemote().sendText(session.getId() + ":" + msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {

        try {
            session.getBasicRemote().sendText(error.getMessage());
        } catch (IOException e) {
            error.printStackTrace();
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg, Session session) {

        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized int getOnlineCount() {
        return onLineNum;
    }

    public static synchronized void addOnlineCount() {
        onLineNum++;
    }

    public static synchronized void subOnlineCount() {
        onLineNum--;
    }
}
