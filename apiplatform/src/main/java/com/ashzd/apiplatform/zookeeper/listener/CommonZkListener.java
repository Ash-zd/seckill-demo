package com.ashzd.apiplatform.zookeeper.listener;

import org.apache.zookeeper.Watcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @file: CommonZkListener
 * @author: Ash
 * @date: 2019/12/10 23:12
 * @description:
 * @since:
 */
@Service
public class CommonZkListener implements ZkListener {

    private CommonZkListener commonZkListener;

    @Override
    public void listen(String path, Watcher watcher) {

    }

    @Override
    public void listen(String path) {

    }
}
