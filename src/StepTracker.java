import java.util.Scanner;
public class StepTracker {

    Converter converter = new Converter();
    int goalByStepsPerDay = 1000;
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int mothScan = scanner.nextInt();
        if ( mothScan < 1 || 12 < mothScan ){
            System.out.println("Неправильный ввод номера месяца");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int daysScan = scanner.nextInt();
        if ((daysScan < 1 || daysScan > 30)) {
            System.out.println("Неправильный ввод номера дня");
            return;
        }
        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0 ){
            System.out.println("Колличесвто шагов не может быть отрицательным");
            return;
        }
        MonthData monthData = monthToData[mothScan - 1];
        monthData.days[daysScan - 1] = steps;
    }

    void changeStepGoal(){
        System.out.println("введите новое количество шагов.");
        int scanStepsPerDay = scanner.nextInt();
        if (scanStepsPerDay < 1 ) {
            System.out.println("Значение меньше или равно нулю!");
            return;
        }
        goalByStepsPerDay = scanStepsPerDay ;
    }

    void printStatistic(){
        System.out.println("Введите число месяца");
         int scanMonthData = scanner.nextInt();
         if (scanMonthData < 1 || 12 < scanMonthData ) {
             System.out.println("Неправильный ввод номера мпесяца!");
             return;
         }
        MonthData monthData = monthToData[scanMonthData - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов: " + monthData.maxSteps());
        System.out.println("Среднее пройденного количества шагов: " + (sumSteps / monthData.days.length));// вывод среднего пройденного количества шагов за месяц
        System.out.println("За этот месяц вы прошли " + converter.convertToKm(sumSteps) + " киллометров");
        System.out.println("За этот месяц вы прожги " + converter.convertStepsToKilocalories(sumSteps) + " килокалорий");
        System.out.println("В этом месяце лучшая серия дней: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
