package com.spw.newcode.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary//更高优先级
public class AlphaDaoMyBatisImpl implements AlphaDao {
    @Override
    public String select() {
        return "mybatis";
    }
}
