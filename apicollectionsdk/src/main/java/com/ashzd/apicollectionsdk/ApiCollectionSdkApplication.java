package com.ashzd.apicollectionsdk;

import com.ashzd.apicollectionsdk.annotation.EnableApiCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @file: ApiCollectionSdkApplication
 * @author: Ash
 * @date: 2019/10/22 13:46
 * @description:
 * @since:
 */
@EnableApiCollection
@EnableConfigurationProperties
@SpringBootApplication
public class ApiCollectionSdkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiCollectionSdkApplication.class, args);
    }
}
