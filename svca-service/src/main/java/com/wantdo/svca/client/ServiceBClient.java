package com.wantdo.svca.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: luanx
 * @email: luanx@wantdo.com
 * @date: 2017-11-15
 */
@FeignClient(name = "svcb-service")
public interface ServiceBClient {

    @GetMapping(value = "/")
    String printServiceB();

    class ServiceBClientFallback implements ServiceBClient {
        private static final Logger logger = LoggerFactory.getLogger(ServiceBClientFallback.class);

        @Override
        public String printServiceB() {
            logger.info("error, into fallback");
            return "service b failed! - falling back";
        }
    }

}
