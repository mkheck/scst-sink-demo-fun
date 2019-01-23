package com.thehecklers.sinkdemofun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;

@EnableBinding(Sink.class)
@SpringBootApplication
public class SinkDemoFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinkDemoFunApplication.class, args);
	}

}

@Slf4j
@MessageEndpoint
class PingCatcher {
	@StreamListener(Sink.INPUT)
	public void logPing(Ping ping) {
		log.info(ping.toString());
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Ping {
	private String group, id, message;
}