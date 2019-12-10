package com.ashzd.apiplatform.config.zookeeper;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CountDownLatch;

/**
 * @file: ZkConfig
 * @author: Ash
 * @date: 2019/12/2 20:12
 * @description:
 * @since:
 */
@Configuration
public class ZkConfig {

    private static Logger logger = LoggerFactory.getLogger(ZkConfig.class);

    @Value("${zookeeper.url}")
    private String zkUrl;

    @Value("${zookeeper.timeout}")
    private int timeout;

    @Bean(name = "zkClient")
    public ZooKeeper zkClient() {
        ZooKeeper zooKeeper = null;
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            zooKeeper = new ZooKeeper(zkUrl, timeout, watchedEvent -> {
                if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            logger.debug("zookeeper connect success");
        } catch (Exception e) {
            logger.error("zookeeper connect failed, error: '{}'", e.getMessage());
        }
        return zooKeeper;
    }


}
