package com.example.signaldemo.module.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SignalingController {

    @MessageMapping("/peer/offer/{otherKey}/{roomId}")
    @SendTo("/topic/peer/offer/{otherKey}/{roomId}")
    public String PeerHandleOffer(@Payload String offer, @DestinationVariable(value = "roomId") String roomId,
                                  @DestinationVariable(value = "otherKey") String otherKey) {
        log.info("[OFFER] {} : {}", otherKey, offer);
        return offer;
    }

    @MessageMapping("/peer/iceCandidate/{otherKey}/{roomId}")
    @SendTo("/topic/peer/iceCandidate/{otherKey}/{roomId}")
    public String PeerHandleIceCandidate(@Payload String candidate, @DestinationVariable(value = "roomId") String roomId,
                                         @DestinationVariable(value = "otherKey") String otherKey) {
        log.info("[ICECANDIDATE] {} : {}", otherKey, candidate);
        return candidate;
    }

    @MessageMapping("/peer/answer/{otherKey}/{roomId}")
    @SendTo("/topic/peer/answer/{otherKey}/{roomId}")
    public String PeerHandleAnswer(@Payload String answer, @DestinationVariable(value = "roomId") String roomId,
                                   @DestinationVariable(value = "otherKey") String otherKey) {
        log.info("[ANSWER] {} : {}", otherKey, answer);
        return answer;
    }

    @MessageMapping("/call/key")
    @SendTo("/topic/call/key")
    public String callKey(@Payload String message) {
        log.info("[Key] : {}", message);
        return message;
    }

    @MessageMapping("/send/key")
    @SendTo("/topic/send/key")
    public String sendKey(@Payload String message) {
        return message;
    }

    @MessageMapping("/peer/start/steam")
    @SendTo("/topic/peer/start/steam")
    public String peerStartSteam(@Payload String message) {
        return message;
    }
}
