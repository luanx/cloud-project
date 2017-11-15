package com.wantdo.svcb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: luanx
 * @email: luanx@wantdo.com
 * @date: 2017-11-15
 */
@RestController
@RefreshScope
public class ServiceBController {

    @Autowired
    EurekaDiscoveryClient discoveryClient;

    @Value("${msg:unknow}")
    private String msg;

    @GetMapping(value = "/")
    public String printServiceB() {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + " (" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ")" + "===>Say " + msg;
    }
}
