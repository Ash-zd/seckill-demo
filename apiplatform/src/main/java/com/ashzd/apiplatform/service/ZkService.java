package com.ashzd.apiplatform.service;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @file: ZkService
 * @author: Ash
 * @date: 2019/12/2 20:27
 * @description:
 * @since:
 */

public interface ZkService {

    Stat exists(String path, boolean needWatch);

    Stat exists(String path, Watcher watcher);

    boolean createNode(String path, String data);

    boolean updateNode(String path, String data);

    boolean deleteNode(String path);

    List<String> getChildren(String path) throws KeeperException, InterruptedException;

    String getData(String path, Watcher watcher);


}
