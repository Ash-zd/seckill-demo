package com.ashzd.apicollectionsdk.service;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @file: ZkWatcherService
 * @author: Ash
 * @date: 2019/12/9 22:54
 * @description:
 * @since:
 */
public interface ZkWatcherService extends Watcher {

    @Override
    void process(WatchedEvent event);

}