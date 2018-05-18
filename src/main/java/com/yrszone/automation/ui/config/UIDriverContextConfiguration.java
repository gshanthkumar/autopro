package com.yrszone.automation.ui.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Loads all related objects into spring context
 *
 */

@Configuration
@ComponentScan(basePackages={"com.yrszone.automation.ui.webdriver","com.yrszone.automation.ui.webanalytics"})
public interface UIDriverContextConfiguration {

}
