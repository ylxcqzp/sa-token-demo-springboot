package com.example.demo.util;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/7/27 15:16
 */
public class WebSocketUtil {

    private static final Map<String, Session> ONLINE_SESSION = new ConcurrentHashMap<>();

    private static long ONLINE_COUNT = 0;


    public static synchronized void addSession(String nickName,Session session) {
        ONLINE_SESSION.put(nickName,session);
        ++ ONLINE_COUNT;
    }

    public static synchronized void remoteSession(String nickName) {
        ONLINE_SESSION.remove(nickName);
        -- ONLINE_COUNT;
    }

    public static void sendMessage(Session session,String message) {
        // getAsyncRemote()和getBasicRemote()异步与同步
        RemoteEndpoint.Async async = session.getAsyncRemote();
        //发送消息
        async.sendText(message);
    }

    //给所有在线用户发送消息
    public static void sendMessageForAll(String message) {
        ONLINE_SESSION.forEach((sessionId,session) -> {
            sendMessage(session,message);
        });
    }

    public static long getCount(){
        return ONLINE_COUNT;
    }
}
