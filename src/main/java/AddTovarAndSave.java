import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTovarAndSave {
    List<TovarAndPrice> spisokTovarov;

    public AddTovarAndSave(){
        spisokTovarov = new ArrayList<>();
    }
    public void addBludo(Scanner scanner){
        System.out.println("Добавить блюдо или напиток: ");
        while (true) {
            System.out.println("Введите название товара (или нажмите 'Завершить'): ");
            String bludoName = scanner.next();

            if (bludoName.equalsIgnoreCase("Завершить")) {
                break;
            }
            System.out.println("Введите стоимость товара: ");
            double bludoPrice = scanner.nextDouble();

            if (bludoPrice < 0){
                System.out.println("Похоже вы ошиблись с вводом, попробуйте еще раз" +
                        "а то вы хотите, чтоб за товар заплатили ВАМ:-) ");
                continue;
            }
            spisokTovarov.add(new TovarAndPrice(bludoName, bludoPrice));
            System.out.println("Товар добавлен");
        }
    }

    public double getAllSumma(){
        return spisokTovarov.stream().mapToDouble(TovarAndPrice::getTovarPrice).sum();

    }
    public List<TovarAndPrice> getAddedTovars() {
        return spisokTovarov;
    }
}
