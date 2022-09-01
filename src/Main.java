import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        task1_2();
        task3();
        task5();
        task6();
        task7();
        task8();
    }

    public static void task1_2() {
        //task 1
        String firstName = "Ivan", middleName = "Ivanovich", lastName = "Ivanov";
        String fullName = lastName + " " + firstName + " " + middleName;
        System.out.printf("ФИО сотрудника — %s\n", fullName);

        //task 2
        System.out.printf("Данные ФИО сотрудника для заполнения отчета — %s\n", fullName.toUpperCase());
    }

    public static void task3() {
        String fullName = "Иванов Семён Семёнович";
        System.out.printf("Данные ФИО сотрудника — %s\n", fullName.replace("ё", "е"));
    }

    public static void task5() {
        //task5
        String fullName = "Ivanov Ivan Ivanovich", firstName, middleName, lastName;
        lastName = fullName.substring(0, fullName.indexOf(" "));
        firstName = fullName.substring(fullName.indexOf(" ") + 1, fullName.lastIndexOf(" "));
        middleName = fullName.substring(fullName.lastIndexOf(" ") + 1);
        System.out.printf("Имя - %s\nОтчество - %s\nФамилия - %s\n", firstName, middleName, lastName);
    }

    public static void task6(){
        String fullName = "ivanov ivan ivanovich";
        System.out.println("Неправильный формат - " + fullName);
        String[] nameData = fullName.split(" ");
//        char[] chars;
        for (int i = 0; i < nameData.length; i++) {
            //first method
//            chars = nameData[i].toCharArray();
//            chars[0] = Character.toUpperCase(chars[0]);
//            nameData[i] = String.valueOf(chars);
            //second method
            nameData[i] = String.valueOf(nameData[i].charAt(0)).toUpperCase() + nameData[i].substring(1);
        }
        fullName = String.join(" ", nameData);
        System.out.println("Правильный формат - " + fullName + "\n");
    }

    public static void task7(){
        String str1 = "0The9quick3brown6fox1", str2 = "jumps4over8the5lazy2dog7";

        // первая ситуация - 2 несортированных строки слить в 1 сортированную
        char[] char1 = str1.toCharArray(), char2 = str2.toCharArray();
        sortedChar(char1);
        sortedChar(char2);
        int j = 0, k = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str1.length() + str2.length(); i++) {
            if(j == str1.length()){
                stringBuilder.append(char2[k++]);
                continue;
            }
            if(k == str2.length()){
                stringBuilder.append(char1[j++]);
                continue;
            }
            if(char1[j] > char2[k]){
                stringBuilder.append(char2[k++]);
            } else {
                stringBuilder.append(char1[j++]);
            }
        }
        System.out.println("Результат - " + stringBuilder);

           //вторая ситуация - отсортировать суммарную строку
//        char[] result = (str1 + str2).toCharArray();
//        sortedChar(result);
//        StringBuilder stringBuilder1 = new StringBuilder();
//        for (char c : result) {
//            stringBuilder1.append(c);
//        }
//        System.out.println("Результат - " + stringBuilder1);
    }

    private static void sortedChar(char[] charArr) {
        for (int i = 0; i < charArr.length; i++) {
            char min = charArr[i];
            for (int j = i + 1; j < charArr.length; j++) {
                if(min > charArr[j]){
                    min = charArr[j];
                    charArr[j] = charArr[i];
                    charArr[i] = min;
                }
            }
        }
    }

    public static void task8(){
        //работает только если строка сортирована
        String string = "the quick brown fox jumps over the lazy dog";
        char[] chars = string.toCharArray();
        sortedChar(chars);                                              // на случай несортированной строки
        int matches;
        System.out.print("повторяющиется символы в строке - ");
        for (int i = 0; i < chars.length; i += matches + 1) {
            matches =0;
            for (int j = i + 1; j < chars.length; j++) {
                if(chars[i] == 32){                                     // исключаем пробелы
                    continue;
                }
                if(chars[i] == chars[j]){
                    matches++;
                }
            }
            if(matches > 0){
                System.out.printf("[%s]", chars[i]);
            }
        }
    }
}