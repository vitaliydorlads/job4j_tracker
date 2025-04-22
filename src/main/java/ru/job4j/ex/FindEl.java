package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Элемента нет");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] value = {"java", "python", "c++"};
        String key = "1С";
        try {
            int index = indexOf(value, key);
            System.out.println("Элемент найдет под индексом " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
