package com.cc;

import com.cc.server.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NettyServerApplication.class, args);
		try {
			new NettyServer().bind("127.0.0.1",8870);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
