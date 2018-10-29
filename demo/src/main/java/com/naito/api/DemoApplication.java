package com.naito.api;

import com.naito.api.fila.Receiver;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

//	@Autowired
//	EmpresaRepository empresaRepository;
//
//	@Autowired
//	ClientApiService clientApiService;
//
//	@Autowired
//	EmailService emailService;
//
//	@Autowired
//	EmpresaService empresaService;

	public static final String topicExchangeName = "spring-boot-exchange";

	static final String queueName = "spring-boot";

	private final RabbitTemplate rabbitTemplate;
	private final Receiver receiver;

	public DemoApplication(Receiver receiver, RabbitTemplate rabbitTemplate) {
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
	}

	public static void main(String[] args) throws InterruptedException{
		SpringApplication.run(DemoApplication.class, args).close();
	}

	@Bean
	 org.springframework.amqp.core.Queue queue() {
		return new org.springframework.amqp.core.Queue(queueName, false);
	}

	@Bean
	 TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	 org.springframework.amqp.core.Binding binding(org.springframework.amqp.core.Queue queue, TopicExchange exchange) {
		return org.springframework.amqp.core.BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}

	@Bean
	 SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
											 MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	 MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
}
