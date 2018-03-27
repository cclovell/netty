package com.cc.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/3/27.
 */
@Component
public class NettyServer implements CommandLineRunner{
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("<<<<<<<<<<<<这个是测试CommandLineRunn接口>>>>>>>>>>>>>>");
    }
}
