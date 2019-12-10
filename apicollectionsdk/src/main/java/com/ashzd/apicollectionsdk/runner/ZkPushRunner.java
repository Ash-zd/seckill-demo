package com.ashzd.apicollectionsdk.runner;

import com.ashzd.apicollectionsdk.constants.ZkConstants;
import com.ashzd.apicollectionsdk.service.ZkService;
import com.ashzd.apicollectionsdk.service.ZkWatcherService;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * @file: ZkPushRunner
 * @author: Ash
 * @date: 2019/12/9 22:33
 * @description:
 * @since:
 */
@Component
public class ZkPushRunner implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(ZkPushRunner.class);

    @Autowired
    private ZkService zkService;
    @Autowired
    private ZooKeeper zkClient;
    @Autowired
    private ZkWatcherService zkWatcherService;

    @Value("${apicollection.ip}")
    private String serverIP;
    @Value("${apicollection.port}")
    private String serverPort;
    @Value("${apicollection.service.name}")
    private String serviceName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 获取url
        Assert.isTrue(StringUtils.isNoneBlank(serverIP), "serverIP is blank");
        String url = "http://" + serverIP + ":" + serverPort + "/v2/api-docs";
        String path = ZkConstants.ZK_ROOT_PATH + "/" + serviceName;
        // 监测是否有持久化节点
        if (Objects.isNull(zkService.exists(ZkConstants.ZK_ROOT_PATH, zkWatcherService))) {
            // 创建根节点
            zkService.createNode(ZkConstants.ZK_ROOT_PATH, "null");
        } else {
            if (Objects.isNull(zkClient.exists(path, zkWatcherService))) {
                // 创建子节点
                zkService.createNode(path, url);
            } else {
                zkService.deleteNode(path);
                zkService.createNode(path, url);
            }
        }
        String value = zkService.getData(path, zkWatcherService);
        logger.info("zk value is: " + value);
    }
}
