package com.ashzd.apiplatform.zookeeper.listener;

import org.apache.zookeeper.Watcher;

/**
 * @file: ZkListener
 * @author: Ash
 * @date: 2019/12/10 23:12
 * @description:
 * @since:
 */
public interface ZkListener {

    /**
     * 监听指定path
     *
     * @param path
     * @param watcher
     */
    void listen(String path, Watcher watcher);

    /**
     * 使用默认watcher监听指定path
     * @param path
     */
    void listen(String path);

}
