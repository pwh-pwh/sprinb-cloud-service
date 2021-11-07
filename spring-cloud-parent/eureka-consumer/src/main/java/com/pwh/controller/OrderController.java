package com.pwh.controller;

import com.pwh.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/goods/{id}")
    public Goods findGoodsByid(@PathVariable("id") int id) {
        System.out.println(id);
        final List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-PROVIDER");
        if(instances == null || instances.size() == 0) {
            return null;
        }
        final ServiceInstance serviceInstance = instances.get(0);
        final String host = serviceInstance.getHost();
        final int port = serviceInstance.getPort();
        System.out.println(host);
        System.out.println(port);
        String url = "http://"+host+":"+port+"/goods/findOne/"+id;
        final Goods goods = restTemplate.getForObject(url, Goods.class);

        return goods;
    }

}
