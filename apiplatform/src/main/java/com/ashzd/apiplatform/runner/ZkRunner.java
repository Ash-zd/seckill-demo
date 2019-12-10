package com.ashzd.apiplatform.runner;

import com.ashzd.apiplatform.constant.ZkConstants;
import com.ashzd.apiplatform.zookeeper.listener.ChildrenZkListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @file: ZkRunner
 * @author: Ash
 * @date: 2019/12/10 23:26
 * @description:
 * @since:
 */
@Component
public class ZkRunner implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(ZkRunner.class);

    @Autowired
    private ChildrenZkListener zkListener;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("ZkRunner start......");
        zkListener.listen(ZkConstants.ZOOKEEPER_ROOT_PATH);
    }
}
