import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        People people = new People();
        int numberPeople = people.reqCountOfPeople(scanner);

        if (numberPeople < 1){
            System.out.println("Видимо никто не пришел, счет не на кого не поделить");
        }
        AddTovarAndSave addTovarAndSave = new AddTovarAndSave();
        addTovarAndSave.addBludo(scanner);

        List<TovarAndPrice> addedTovars = addTovarAndSave.getAddedTovars();
        System.out.println("Добавленные товары:");
        for (TovarAndPrice tovar : addedTovars) {
            System.out.println(tovar.getTovarName() + ": " + formatCurrency(tovar.getTovarPrice()));
        }

        double allSumma = addTovarAndSave.getAllSumma();
        double onePersonSumma = allSumma / numberPeople;
        System.out.println("Общий счет: " + formatCurrency (allSumma));
        System.out.println("Сумма на каждого: " + formatCurrency (onePersonSumma));
    }



    private static String formatCurrency(double amount) {
        String formattedAmount = String.format("%.2f", amount);
        formattedAmount = formattedAmount.replace(',', '.'); // Заменить запятую на точку
        String[] parts = formattedAmount.split("\\.");
        int integerPart = (int) Double.parseDouble(parts[0]);

        if (integerPart % 10 == 1 && integerPart % 100 != 11) {
            return formattedAmount + " рубль";
        } else if ((integerPart % 10 >= 2 && integerPart % 10 <= 4) && (integerPart % 100 < 12 || integerPart % 100 > 14)) {
            return formattedAmount + " рубля";
        } else {
            return formattedAmount + " рублей";
        }
    }
}