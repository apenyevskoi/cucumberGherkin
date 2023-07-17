package com.cucumber.gherkin.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Singleton configuration class of linking properties file and configuration object
 */
public class Configuration {

    private static Configuration configuration;

    private Properties properties;

    private Configuration(){}

    /**
     * Create configuration, set properties file
     * @return configuration object
     */
    public static Configuration getInstance() {
        if (configuration == null){
            configuration = new Configuration();
            configuration.properties = new Properties();
            try {
                configuration.properties.load(Configuration.class.getResourceAsStream("/config/target.properties"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return configuration;
    }

    /**
     * Get definite property
     * @param name
     * @return
     */
    public String getProperty(String name){
        return getProperties().getProperty(name);
    }

    /**
     * Get all instances of property file
     * @return
     */
    public Properties getProperties(){
        return properties;
    }

    /**
     * Get "url" property
     * @return
     */
    public String getBase(){
        return properties.getProperty("url");
    }
}