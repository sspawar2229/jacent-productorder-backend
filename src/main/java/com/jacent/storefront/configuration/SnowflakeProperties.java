package com.jacent.storefront.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "snowflake")
@Data
public class SnowflakeProperties {
    private String url;
    private String user;
    private String privateKeyFile;
    private String privateKeyPassphrase;
    private String database;
    private String schema;
    private String warehouse;
    private String role;
}
