package com.cc;

import com.cc.client.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(NettyClientApplication.class, args);
		try {
			new NettyClient().connect("127.0.0.1",8870);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
