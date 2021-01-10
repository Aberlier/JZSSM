package com.jzssm.fhf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.utils
 * @ClassName: ScheduledMgr
 * @date ：Created in 2021/1/9 16:27
 * @description：调度器
 * @modified By：
 * @version: v1.0.0$
 */
@Component
public class ScheduledMgr {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 构造函数中打印初始化时间
     */
    /*public ScheduledMgr() {
        logger.info("首先会去查询一下有多少条数据用于分页显示"+dateFormat.format(new Date()));
    }*/

    /**
     * fixedDelay属性定义调度间隔时间。调度需要等待上一次调度执行完成。
     */
    public void testSelecrtFixedDelay() throws Exception {
      /*  Thread.sleep(6000);*/
        logger.info("首先会去查询一下有多少条数据用于分页显示"+dateFormat.format(new Date()));
//        new ScheduledMgr();

    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void testDeleteFixedDelay() throws Exception {
      /*  Thread.sleep(6000);*/
        logger.info("删除监测时间与当前时间比超过24小时的数据"+dateFormat.format(new Date()));
        testSelecrtFixedDelay();
    }

/*    *//**
     * fixedRate属性定义调度间隔时间。调度不等待上一次调度执行完成。
     *//*
    @Scheduled(fixedRate = 5000)
    public void testFixedRate() throws Exception {
        Thread.sleep(6000);
        logger.info("Current time: {}"+dateFormat.format(new Date()));
    }

    *//**
     * initialDelay属性定义初始化后的启动延迟时间
     *//*
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void testInitialDelay() throws Exception {
        Thread.sleep(6000);
        logger.info("Current time: {}"+dateFormat.format(new Date()));
    }

    *//**
     * cron属性支持使用cron表达式定义触发条件
     *//*
    @Scheduled(cron = "0/5 * * * * ?")
    public void testCron() throws Exception {
        Thread.sleep(6000);
        logger.info("Current time: {}"+dateFormat.format(new Date()));
    }*/
}
