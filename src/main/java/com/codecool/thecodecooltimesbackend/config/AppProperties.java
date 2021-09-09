package com.codecool.thecodecooltimesbackend.config;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class AppProperties {

    private static String NEWS_API_BASE_URL;
    private static String NEWS_API_PERSISTENCE;
    private static String QUOTE_API_URL;

    static {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(appConfigPath));
            NEWS_API_BASE_URL = p.getProperty("news_api_base_url", null);
            NEWS_API_PERSISTENCE = p.getProperty("news_api_persistence", null);
            QUOTE_API_URL = p.getProperty("quote_api_url", null);
        } catch (IOException e) {
            System.out.println("'app.properties' not found!");
        }
    }

    public static String getQuoteApiUrl() {
        return QUOTE_API_URL;
    }
}

