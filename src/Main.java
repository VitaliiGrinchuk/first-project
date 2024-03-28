import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker saveStep = new StepTracker(scanner);
        System.out.println("Добро пожаловать !" );
        while (true) {
            printMenu();
            int actionNumber = scanner.nextInt();
            if (actionNumber == 1) {
                saveStep.addNewNumberStepsPerDay();
                System.out.println("количество шагов сохранено!");
            } else if (actionNumber == 2) {
                saveStep.changeStepGoal();
                System.out.println("Цель по количеству шагов изменина!");
            } else if (actionNumber == 3) {
                saveStep.printStatistic();
            } else if (actionNumber == 0) {
                break;
            } else {
                System.out.println("Извините, такой команды нет.");
            }
        }
    }

     static void printMenu() {
                System.out.println("Меню приложения" +
                "\n1. ввести количество шагов за определённый день;" +
                "\n2. изменить цель по количеству шагов в день;" +
                "\n3. напечатать статистику за определённый месяц;" +
                "\n0. выйти из приложения.");

    }
}

