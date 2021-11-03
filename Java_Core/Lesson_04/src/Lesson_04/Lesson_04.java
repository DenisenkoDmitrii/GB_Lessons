package Lesson_04;

import java.util.*;

/*
Lesson_04 (GB.Java Core)
Denisenko Dmitriy (03.11.2021)
 */
public class Lesson_04 {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            arrayList.add("Запись_" + i);
            if (i % 2 == 0) {
                arrayList.add("Запись_" + i);
            }
        }
        System.out.println("Задание № 1");
        System.out.println("Наш массив изначальный \n" + arrayList);

        // Переводим arrayList в linkedHashSet и он сам убирает дубликаты (сохраняет порядок добавления записей)
        System.out.println("Наш массив через LinkedHashSet (вариант 1)");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(arrayList);
        System.out.println(linkedHashSet);
        int j = arrayList.size() - linkedHashSet.size();
        System.out.println("количество элементов: " + linkedHashSet.size() + ", удалено дубликатов: " + j);

        // Переводим arrayList в hashSet и он сам убирает дубликаты (не сортирует)
        HashSet<String> hashSet = new HashSet<>(); //можно так Set<String> linkedHashSet = new LinkedHashSet<>(arrayList);
        for (String s : arrayList) {
            hashSet.add(s); // можно вот так: hashSet.addAll(arrayList);
        }
        int y = arrayList.size() - hashSet.size();
        System.out.println("Наш массив через HashSet (вариант 2) \n" + hashSet + "\n количество элементов: " + hashSet.size() + ", удалено дубликатов: " + y);

        //Переводим arrayList в TreeSet и он сам убирает дубликаты (но сортирует криво)
        System.out.println("Наш массив через TreeSet (вариант 3)");
        TreeSet<String> treeSet = new TreeSet<>(arrayList);
        System.out.println(treeSet);

        /*Iterator<String> iter = arrayList.iterator();
        int sum = 0;
        while (iter.hasNext()) {
            String str = iter.next();
            for (int i = 0; i < arrayList.size(); i++) {
                if (str.equals(arrayList.get(i))) {
                    sum++;
                }
                System.out.println(arrayList.get(i) + " встречается " + sum + " раз");
            }
        }
         */
        // Посмотрел видео разбор задания, но менять своё не стал. т.к.:
        // Реализовал таким образом (телефоны не записывал в ArrayList), т.к. из задания понял, что не у 1 человека будет 2-3 и более телефона,
        // а что будет два разных человека, но с одинаковой фамилией и собственным телефоном уникальным.
        // По принципу - авторизация на сайте по номеру телефона (уникального) а фамилии могут быть одинаковые, и задача в том, чтобы
        // вывести телефоны однофамильцев
        // В разобранном в видео примере (для себя памятка):
        // HashMap<String, ArrayList<String>> phoneList = new HashMap<>();
        // public void add(String name, String phone) { if (phoneList.get(name)==null)
        // ArrayList<String> phones = new ArrayList<>();
        // phones.add(phone)
        // phoneList.put(name, phones)
        // else {phoneList.get(name).add(phone)} - записывает телефон в существующий ArrayList phones
        // public ArrayList<String> get(String name) { return phoneList.get(name)} - возвращает ArrayList phones по имени

        System.out.println("Задание № 2");
        PhoneList phoneList = new PhoneList();
        phoneList.add("89090909090", "Dima1");
        phoneList.add("89090909091", "Dima2");
        phoneList.add("89090909092", "Dima3");
        phoneList.add("89090909093", "Dima4");
        phoneList.add("89090909094", "Dima2");
        phoneList.get("Dima2");
        phoneList.get("Dima4");
    }
}
