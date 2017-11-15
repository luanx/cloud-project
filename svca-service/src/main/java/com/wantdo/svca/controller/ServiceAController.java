package com.wantdo.svca.controller;

import com.wantdo.svca.client.ServiceBClient;
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

@RefreshScope
@RestController
public class ServiceAController {

    @Autowired
    EurekaDiscoveryClient discoveryClient;

    @Autowired
    private ServiceBClient serviceBClient;

    @Value("${name:unknown}")
    private String name;

    @GetMapping(value = "/")
    public String printServiceA() {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + " (" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ")"
                + "===>name:" + name + "<br/>" + serviceBClient.printServiceB();
    }
}
