package com.pwh.service;

import com.pwh.dao.GoodsDao;
import com.pwh.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    public Goods getGoodsById(int id) {
        return goodsDao.getGoodsByid(id);
    }
}
