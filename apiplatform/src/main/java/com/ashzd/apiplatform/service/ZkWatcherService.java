package com.ashzd.apiplatform.service;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.stereotype.Service;

/**
 * @file: ZkWatcherService
 * @author: Ash
 * @date: 2019/12/2 22:18
 * @description:
 * @since:
 */
public interface ZkWatcherService extends Watcher {

    @Override
    void process(WatchedEvent event);

}
