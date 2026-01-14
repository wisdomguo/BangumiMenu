package com.bangumimenu.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 应用程序配置类
 * 用于加载和访问 application.properties 文件中的配置
 */
public class AppConfig {
    private static final String CONFIG_FILE = "/application.properties";
    private static Properties properties = new Properties();

    static {
        loadConfig();
    }

    private static void loadConfig() {
        try (InputStream inputStream = AppConfig.class.getResourceAsStream(CONFIG_FILE)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("无法找到配置文件: " + CONFIG_FILE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("加载配置文件失败", e);
        }
    }

    /**
     * 获取字符串类型的配置值
     *
     * @param key 配置键
     * @return 配置值，如果不存在则返回 null
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * 获取字符串类型的配置值，带默认值
     *
     * @param key          配置键
     * @param defaultValue 默认值
     * @return 配置值，如果不存在则返回默认值
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * 获取整数类型的配置值
     *
     * @param key 配置键
     * @return 配置值，如果不存在或解析失败则返回 -1
     */
    public static int getIntProperty(String key) {
        try {
            String value = properties.getProperty(key);
            return value != null ? Integer.parseInt(value) : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * 获取整数类型的配置值，带默认值
     *
     * @param key          配置键
     * @param defaultValue 默认值
     * @return 配置值，如果不存在或解析失败则返回默认值
     */
    public static int getIntProperty(String key, int defaultValue) {
        try {
            String value = properties.getProperty(key);
            return value != null ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 获取布尔类型的配置值
     *
     * @param key 配置键
     * @return 配置值，如果不存在则返回 false
     */
    public static boolean getBooleanProperty(String key) {
        String value = properties.getProperty(key);
        return value != null && Boolean.parseBoolean(value);
    }

    /**
     * 获取布尔类型的配置值，带默认值
     *
     * @param key          配置键
     * @param defaultValue 默认值
     * @return 配置值，如果不存在则返回默认值
     */
    public static boolean getBooleanProperty(String key, boolean defaultValue) {
        String value = properties.getProperty(key);
        return value != null ? Boolean.parseBoolean(value) : defaultValue;
    }
}