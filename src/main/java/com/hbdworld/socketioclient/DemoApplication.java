package com.hbdworld.socketioclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URISyntaxException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		//socket.io
		SocketDemo socketDemo = new SocketDemo();
		try {
			socketDemo.test();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
