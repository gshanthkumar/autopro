package com.yrszone.automation.ui.testsetup;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource({"test_environment.properties"})
@ComponentScan(basePackages={"com.yrszone.automation.ui.testsetup","com.yrszone.automation.ui.webdriver"})

public class TestConfig {


}

