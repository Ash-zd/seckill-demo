package com.ashzd.apicollectionsdk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @file: SwaggerConfig
 * @author: Ash
 * @date: 2019/11/26 13:44
 * @description:
 * @since:
 */
@ConfigurationProperties(prefix = "apicollection.swagger")
public class SwaggerConfig {

    private String packagePath;

    private String docTitle;

    private String docDescription;

    private String docDeployUrl;

    private String contactName;

    private String contactUrl;

    private String contactEmail;

    private String docVersion;
}
