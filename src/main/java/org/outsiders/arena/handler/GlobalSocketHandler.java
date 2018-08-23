package org.outsiders.arena.handler;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import org.outsiders.arena.handler.SocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Service
public class GlobalSocketHandler
extends SocketHandler {
    public static Logger LOG = LoggerFactory.getLogger(GlobalSocketHandler.class);
    protected WebSocketSession session;

    public void processMessage(WebSocketSession webSocketSession, TextMessage message) throws InterruptedException, IOException {
        Map valueMap = (Map)new Gson().fromJson((String)message.getPayload(), Map.class);
        webSocketSession.sendMessage((WebSocketMessage)this.createTextMessage(valueMap));
    }

    public String processMapEntry(Map valueMap) {
        StringBuilder response = new StringBuilder();
        valueMap.forEach((k, v) -> response.append(k.toString() + ": " + v.toString() + ", "));
        return response.toString();
    }

    public TextMessage createTextMessage(Map valueMap) {
        return new TextMessage((CharSequence)this.processMapEntry(valueMap));
    }

    public void handleTextMessage(WebSocketSession session, TextMessage message) throws InterruptedException, IOException {
        for (WebSocketSession webSocketSession : this.sessions) {
            this.session = session;
            this.processMessage(webSocketSession, message);
        }
    }
}