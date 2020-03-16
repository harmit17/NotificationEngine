package com.finablr.platform.notification.jmsconfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.finablr.platform.notification")
@Import({JmsConfiguration.class})
public class AppConfig {

}
