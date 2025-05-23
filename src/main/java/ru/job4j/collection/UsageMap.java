package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mail@mail.ru", "Denisov Ivan");
        map.put("qaaaqqq@bk.ru", "Kashin Dmitriy");
        map.put("yandex@mail.ru", "Kabanob Ilia");
        map.put("poshta@bk.ru", "Ivanteev Vasia");
        map.put("poshta@bk.ru", "Prokofieva Svetlana");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}

