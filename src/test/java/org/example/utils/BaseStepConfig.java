package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseStepConfig {
    private static Properties configprop;
    private static Properties dbconfigprop;

    public BaseStepConfig(){
    }

    public void onPrepare(){
        System.setProperty("--illegal-access", "deny");
        configprop = configprop == null ? new Properties() : configprop;
        System.out.println(configprop.isEmpty());
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/properties/configuration.properties");
            configprop.load(fileInputStream);
            System.out.println(configprop.getProperty("mainurl"));
        } catch (IOException e) {
            throw new RuntimeException("Configuration File not found in specified path"+e);
        }

    }

    public static Properties getConfigprop(){
        return configprop;
    }


    public static void main(String args[]){
//     new BaseStepConfig().onPrepare();
//        BaseStepConfig.on
        System.out.println(BaseStepConfig.getConfigprop().getProperty("mainurl").toString());
    }

}
