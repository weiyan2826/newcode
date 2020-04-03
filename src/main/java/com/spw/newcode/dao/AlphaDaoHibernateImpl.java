package com.spw.newcode.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl  implements AlphaDao{
    @Override
    public String select() {
        return "hibernate";
    }
}
