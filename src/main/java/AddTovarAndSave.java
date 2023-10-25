import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class AddTovarAndSave  {
    List<TovarAndPrice> spisokTovarov;

    public AddTovarAndSave() {
        spisokTovarov = new ArrayList<>();
    }

    public void addBludo (Scanner scanner) {
        System.out.println("Добавить блюдо или напиток: ");
        while (true) {
            System.out.println("Введите название товара (или нажмите 'Завершить'): ");
            String bludoName = scanner.next();

            if (bludoName.equalsIgnoreCase("Завершить")) {
                break;
            }

            if (!bludoName.matches("[a-zA-Zа-яА-Я]+")) {
                System.out.println("У нас в ресторане все названия блюд пишутся буквами, введите еще раз: ");
                continue;
            }

            double bludoPrice = -1;
            boolean noPrice = false;
            while (!noPrice) {
                System.out.println("Введите цену: ");
                try {
                    bludoPrice = scanner.nextDouble();
                    noPrice = bludoPrice >= 0;
                } catch (InputMismatchException e) {
                    System.out.println("Ввод осуществляется только цифрами, попробуйте еще раз");
                    scanner.next();
                }
            }

            if (bludoPrice < 0) {
                System.out.println("Похоже вы ошиблись с вводом, попробуйте еще раз" +
                        "а то вы хотите, чтоб за товар заплатили ВАМ:-) ");
                continue;
            }
            spisokTovarov.add(new TovarAndPrice(bludoName, bludoPrice));
            System.out.println("Товар добавлен");
        }
    }
    public double getAllSumma() {
        return spisokTovarov.stream().mapToDouble(TovarAndPrice::getTovarPrice).sum();
    }
    public List<TovarAndPrice> getAddedTovars() {
        return spisokTovarov;
    }
}
