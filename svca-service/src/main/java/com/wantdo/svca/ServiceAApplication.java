package com.wantdo.svca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: luanx
 * @email: luanx@wantdo.com
 * @date: 2017-11-13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceAApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }
}
