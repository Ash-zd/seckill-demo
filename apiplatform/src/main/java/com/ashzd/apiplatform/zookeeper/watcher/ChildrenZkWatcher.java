package com.ashzd.apiplatform.zookeeper.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @file: ChildrenZkWatcher
 * @author: Ash
 * @date: 2019/12/11 0:58
 * @description:
 * @since:
 */
@Service
public class ChildrenZkWatcher implements ZkWatcher {
    private static Logger logger = LoggerFactory.getLogger(ChildrenZkWatcher.class);

    @Override
    public void process(WatchedEvent event) {
        logger.info("【Watcher监听事件】= '{}'", event.getState());
        logger.info("【监听路径为】= '{}'", event.getPath());
        // 三种监听类型：创建，删除，更新
        logger.info("【监听的类型为】= '{}'", event.getType());
    }
}
