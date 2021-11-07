package com.pwh.controller;

import com.pwh.domain.Goods;
import com.pwh.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("/findOne/{id}")
    public Goods findOne(@PathVariable("id") int id) {
        final Goods goods = goodsService.getGoodsById(id);
        return goods;
    }
}
