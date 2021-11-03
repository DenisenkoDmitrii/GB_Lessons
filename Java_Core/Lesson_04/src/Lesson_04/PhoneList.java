package Lesson_04;

import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneList {
    LinkedHashMap<String, String> phoneList = new LinkedHashMap<>();
    String surname;
    String phone;

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public void add(String phone, String surname) {
        phoneList.put(phone, surname);
    }

    public void get(String surname) {
        for (Map.Entry<String, String> g : phoneList.entrySet()) {
            if (surname.equals(g.getValue())) {
                System.out.println(surname + " " + g.getKey());
            }
        }
    }
}
