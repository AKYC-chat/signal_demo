package com.example.signaldemo.module.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@Component
public class WebSocketEventListener {

    /*
    'SessionConnectedEvent' STOMP session 연결되었을때 발생.
    'SessionDisconnectEvent' STOMP session 이 끝났을 때 발생
    */

    @EventListener
    public void handleWebsocketConnectListener(SessionConnectedEvent event) {
        String sessionId = StompHeaderAccessor
                .wrap(event.getMessage())
                .getSessionId();

        log.info("웹소켓 접속 : {}",sessionId);
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
        String sessionId = StompHeaderAccessor
                .wrap(event.getMessage())
                .getSessionId();

        log.info("웹소켓 종료 : {}",sessionId);
    }

}
