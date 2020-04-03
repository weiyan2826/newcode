package com.spw.newcode;

import com.spw.newcode.dao.AlphaDao;
import com.spw.newcode.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class NewcodeApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Test
    void contextLoads() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    @Test
    public void testApplicationContext(){
        System.out.println(applicationContext);
        AlphaDao alphaDao=applicationContext.getBean(AlphaDao.class);
        System.out.println(alphaDao.select());
        alphaDao= (AlphaDao) applicationContext.getBean("alphaHibernate");
        System.out.println(alphaDao.select());
    }

    @Test
    public void testBeanManagement() {
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);

        alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
    }
    @Test
    public void testBeanConfig() {
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }
    @Autowired
    @Qualifier("alphaHibernate")//两个service指定注入某个实现bean
    AlphaDao alphaDao;
    @Autowired
    SimpleDateFormat simpleDateFormat;
    @Autowired
    AlphaService alphaService;
    @Test
    public void testDI(){
        System.out.println(alphaDao);
        System.out.println(alphaService);
        System.out.println(simpleDateFormat);
    }
}
