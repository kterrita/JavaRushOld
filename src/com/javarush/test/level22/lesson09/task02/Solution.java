package com.javarush.test.level22.lesson09.task02;

import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
   /* public static void main(String[] args)
    {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        Map<String, String> nullMap = new LinkedHashMap<>();
        nullMap.put(null, "123");
        System.out.println(getCondition(map).toString());
        System.out.println(getCondition(nullMap).toString());
    }*/

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry : params.entrySet()) {
            if(entry.getValue() == null || entry.getKey() == null){
                continue;
            }
            sb.append(entry.getKey());
            sb.append(" = ");
            sb.append("'" + entry.getValue() + "'");
            sb.append(" and ");
        }
        if(!sb.toString().isEmpty())
        {
            sb.delete(sb.length() - 5, sb.length());
        }
        return sb;
    }
}
