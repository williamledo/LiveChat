package tech.ledo.livechatms.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	public void configureMessageBroker(MessageBrokerRegistry registry) { // Faz a configuração do broker de mensagens
		registry.enableSimpleBroker("/topics"); // Define os prefixos para tópicos
		registry.setApplicationDestinationPrefixes("/app"); // Define o prefixo para destinos de aplicação
	}
	
	public void registerStompEndpoints(StompEndpointRegistry registry) { // Registra o endpoint STOMP
		registry.addEndpoint("/livechat-websocket"); /// Define o endpoint WebSocket com SockJS e permite todas as origens
	}
	
}
