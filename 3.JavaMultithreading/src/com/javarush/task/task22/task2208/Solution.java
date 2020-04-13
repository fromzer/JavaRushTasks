package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> pair : params.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (key != null && value != null) {
                if (sb.toString().equals("")) {
                    sb.append(key + " = " + "'" + value + "'");
                } else {
                    sb.append(" and " + key + " = " + "'" + value + "'");
                }
            }
            else {
                sb.append("");
            }
        }
//        sb.replace(sb.length() - 4, sb.length(), "");
        return sb.toString();
    }
}
