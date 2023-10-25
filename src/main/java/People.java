import java.util.InputMismatchException;
import java.util.Scanner;

public class People {
    public int reqCountOfPeople (Scanner scanner) {
        while (true){
            try {
                System.out.println("Сколько человек будут платить? ");
                int countOfPeople = scanner.nextInt();
                if (countOfPeople < 1) {
                    System.out.println("Введите еще раз! А то судя по этим данным вы вообще не пришли");
                }
                else if (countOfPeople == 1) {
                    System.out.println("Попробуйте ввести еще раз, а то платить будете один! ");
                }
                else {
                    return countOfPeople;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Похоже, что вы ввели не цифры. Попробуйте еще раз ");
                scanner.next();
            }
        }
    }
}
