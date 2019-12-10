package com.ashzd.apicollectionsdk.service.impl;

import com.ashzd.apicollectionsdk.constants.ZkConstants;
import com.ashzd.apicollectionsdk.service.ZkService;
import com.ashzd.apicollectionsdk.service.ZkWatcherService;
import org.apache.zookeeper.WatchedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @file: ZkWatcherServiceImpl
 * @author: Ash
 * @date: 2019/12/9 22:54
 * @description:
 * @since:
 */
@Service
public class ZkWatcherServiceImpl implements ZkWatcherService {
    private static Logger logger = LoggerFactory.getLogger(ZkWatcherServiceImpl.class);

    @Autowired
    private ZkService zkService;
    @Value("${apicollection.service.name}")
    private String serviceName;

    @Override
    public void process(WatchedEvent event) {
        logger.info("【Watcher监听事件】={}", event.getState());
        logger.info("【监听路径为】={}", event.getPath());
        // 三种监听类型：创建，删除，更新
        logger.info("【监听的类型为】={}", event.getType());
    }
}
