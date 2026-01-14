package com.bangumimenu.utils;

import com.bangumimenu.entity.Bangumi;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * JSON工具类，用于处理Bangumi数据的读写
 */
public class JsonUtils {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                @Override
                public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
                        throws JsonParseException {
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        return LocalDateTime.parse(json.getAsString(), formatter);
                    } catch (DateTimeParseException e) {
                        return null; // 如果解析失败，返回null
                    }
                }
            })
            .create();

    /**
     * 从JSON文件读取Bangumi列表
     * @param filePath 文件路径
     * @return Bangumi对象列表
     */
    public static List<Bangumi> readBangumiList(String filePath) {
        try (InputStreamReader reader = new InputStreamReader(
                JsonUtils.class.getResourceAsStream(filePath), StandardCharsets.UTF_8)) {
            
            Type listType = new TypeToken<List<Bangumi>>(){}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JsonSyntaxException e) {
            System.err.println("JSON格式错误: " + e.getMessage());
            return null;
        }
    }

    /**
     * 将Bangumi列表写入JSON文件
     * @param bangumis Bangumi对象列表
     * @param filePath 文件路径（绝对路径或相对路径）
     */
    public static void writeBangumiList(List<Bangumi> bangumis, String filePath) {
        String json = gson.toJson(bangumis);
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(filePath), StandardCharsets.UTF_8)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析日期时间字符串
     * @param dateTimeStr 日期时间字符串
     * @return LocalDateTime对象
     */
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(dateTimeStr, formatter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 格式化日期时间
     * @param dateTime LocalDateTime对象
     * @return 日期时间字符串
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}