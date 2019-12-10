package com.ashzd.apiplatform.zookeeper.listener;

import com.ashzd.apiplatform.zookeeper.service.ZkService;
import com.ashzd.apiplatform.zookeeper.watcher.ChildrenZkWatcher;
import com.ashzd.apiplatform.zookeeper.watcher.CommonZkWatcher;
import com.ashzd.apiplatform.zookeeper.watcher.ZkWatcher;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @file: ChildrenZkListener
 * @author: Ash
 * @date: 2019/12/10 23:17
 * @description:
 * @since:
 */
@Service
public class ChildrenZkListener implements ZkListener {

    private static Logger logger = LoggerFactory.getLogger(ChildrenZkListener.class);

    @Autowired
    private ZooKeeper zkClient;
    @Autowired
    private ZkService zkService;
    @Autowired
    private ChildrenZkWatcher childrenWatcher;

    @Override
    public void listen(String path, Watcher watcher) {
        try {
            // 检查是否存在这个path
            if (Objects.isNull(zkService.exists(path, watcher))) {
                zkService.createNode(path, "");
                logger.debug("path: '{}' children are '[]'", path);
            } else {
                List<String> children = zkClient.getChildren(path, watcher);
                logger.debug("path: '{}' children are '{}'", path, children);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listen(String path) {
        listen(path, childrenWatcher);
    }
}
