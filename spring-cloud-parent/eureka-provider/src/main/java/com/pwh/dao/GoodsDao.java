package com.pwh.dao;

import com.pwh.domain.Goods;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDao {
    public Goods getGoodsByid(int id) {
        return new Goods(id,"小米",2999d,10000);
    }
}
