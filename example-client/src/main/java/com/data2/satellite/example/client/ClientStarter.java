package com.data2.satellite.example.client;

import com.data2.satellite.example.server.api.HiService;
import com.data2.satellite.rpc.server.client.client.RpcProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author data2
 * @description
 * @date 2021/4/1 下午5:59
 */
@SpringBootApplication
@RestController
@ComponentScan("com.data2.satellite")
public class ClientStarter {

    @Autowired
    private RpcProxy rpcProxy;

    public static void main(String[] args) {
        SpringApplication.run(ClientStarter.class);
    }

    @GetMapping("/test")
    public String test() {
        return rpcProxy.create(HiService.class).hi();
    }
}