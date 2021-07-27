package com.example.demo.controller.websocket;

import com.example.demo.util.WebSocketUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/7/27 15:13
 */
//由于是websocket 所以原本是@RestController的http形式
//直接替换成@ServerEndpoint即可，作用是一样的 就是指定一个地址
//表示定义一个websocket的Server端
@ServerEndpoint(value = "/socket/{nickName}")
@Component
@Slf4j
public class WebSocketController {

    /**
     * 连接事件
     * @param nickName
     */
    @OnOpen
    public void onOpen(@PathParam("nickName")String nickName, Session session) {
        WebSocketUtil.addSession(nickName,session);
        String message = "欢迎新游客[" + nickName + "]进入聊天室！ 当前在线人数：" + WebSocketUtil.getCount() + "人";
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnClose
    public void onClose(@PathParam("nickName")String nickName, Session session) {
        WebSocketUtil.remoteSession(nickName);
        String message = "游客[" + nickName + "]已离开聊天室！ 当前在线人数：" + WebSocketUtil.getCount() + "人";
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("nickName")String nickName,String message) {
        String info = "游客[" + nickName + "]: " + message;
        WebSocketUtil.sendMessageForAll(info);
    }

    @OnError
    public void onError(Session session,Throwable throwable){
        log.error("发生异常：{}",throwable.getMessage());
        try {
            session.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
