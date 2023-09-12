import java.util.Scanner;
import static java.lang.Integer.parseInt;

public abstract class Main {

    static String result;

    public static void main(String[] args) {

        System.out.println("Введите выражение [2 + 2] или два римских числа от I до X:[V + V] + Enter. (Внимание: данные необходимо вносить через пробел!)");
        Scanner scanner = new Scanner(System.in);
        String split = scanner.nextLine();
        calc(split);
        System.out.println(result);
    }
    public static String calc(String input) {

        String[] arrayAfterSplit = input.split(" ");
        String firstElement = arrayAfterSplit[0];
        String secondElement = arrayAfterSplit[2];
        String operator = arrayAfterSplit[1];
        if (input.contains("I") || input.contains("V") || input.contains("X")) {

            String numChange1 = romeNumToArabic(firstElement);
            String numChange2 = romeNumToArabic(secondElement);

            int num1 = parseInt(numChange1);
            int num2 = parseInt(numChange2);

            if ((num1 > 0 && num2 > 0) && (num1 < 11 && num2 < 11)) { //ограничиваем диапозон чисел от 1 до 10 включительно.
                switch (operator) {
                    case "+" -> {
                        int summ = num1 + num2;
                        result = arabicNumToRome(summ);
                        return result;
                    }
                    case "-" -> {
                        int summ;
                        summ = num1 - num2;
                        result = arabicNumToRome(summ);
                        return result;
                    }
                    case "*" -> {
                        int summ;
                        summ = num1 * num2;
                        result = arabicNumToRome(summ);
                        return result;
                    }
                    case "/" -> {
                        int summ;
                        summ = num1 / num2;
                        result = arabicNumToRome(summ);
                        return result;
                    }
                }
            } else {
                System.out.println("Числа не соответствуют условию");
                return input;
            }

        } else {//если в строке только арабские цифры

            int firstArabicNum = parseInt(firstElement);
            int secondArabicNum = parseInt(secondElement);

            if ((firstArabicNum > 0 && secondArabicNum > 0) && (firstArabicNum < 11 && secondArabicNum < 11)) { //ограничиваем диапозон чисел от 1 до 10 включительно.

                switch (operator) {
                    case "+" -> {
                        result = String.valueOf(firstArabicNum + secondArabicNum);
                        return result;
                    }
                    case "-" -> {
                        result = String.valueOf(firstArabicNum - secondArabicNum);
                        return result;
                    }
                    case "*" -> {
                        result = String.valueOf(firstArabicNum * secondArabicNum);
                        return result;
                    }
                    case "/" -> {
                        result = String.valueOf(firstArabicNum / secondArabicNum);
                        return result;
                    }
                    default -> throw new IllegalStateException("Не соответствующий символ: " + operator);
                }

            } else {
                throw new IllegalStateException("Числа не соответствуют условию");
            }
        }
        return null;
    }

    public static String romeNumToArabic(String input){

        return switch (input) {
            case "I" -> "1";
            case "II" -> "2";
            case "III" -> "3";
            case "IV" -> "4";
            case "V" -> "5";
            case "VI" -> "6";
            case "VII" -> "7";
            case "VIII" -> "8";
            case "IX" -> "9";
            case "X" -> "10";
            default -> input + " не является римской";
        };
    }


    private static String arabicNumToRome(int input) {
        if (input > 0) {
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            return roman[input];
        }
        throw new IllegalStateException("Отрицательное значение или 0");
    }
}











