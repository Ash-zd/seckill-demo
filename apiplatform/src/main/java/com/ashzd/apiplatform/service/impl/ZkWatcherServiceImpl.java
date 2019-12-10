package com.ashzd.apiplatform.service.impl;

import com.ashzd.apiplatform.service.ZkWatcherService;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @file: ZkWatcherServiceImpl
 * @author: Ash
 * @date: 2019/12/2 22:19
 * @description:
 * @since:
 */
@Service
public class ZkWatcherServiceImpl implements ZkWatcherService {

    private static Logger logger = LoggerFactory.getLogger(ZkWatcherServiceImpl.class);

    @Override
    public void process(WatchedEvent event) {
        logger.info("【Watcher监听事件】={}", event.getState());
        logger.info("【监听路径为】={}", event.getPath());
        // 三种监听类型：创建，删除，更新
        logger.info("【监听的类型为】={}", event.getType());
    }
}
