import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double rate, int period) {
        double pay = amount * Math.pow((1 + rate / 12), 12 * period);
        return toRound(pay, 2);
    }

    double calculateSimplePercent(double amount, double rate, int period) {
        return toRound(amount + amount * rate * period, 2);
    }

    double toRound(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void doImportantJob() {
        int period;
        int action;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях: ");
        int amount = userInput.nextInt();
        System.out.println("Введите срок вклада в годах: ");
        period = userInput.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией: ");
        action = userInput.nextInt();
        double out = 0;
            if (action == 1) {
                out = calculateSimplePercent(amount, 0.06, period);
            } else if (action == 2) {
                out = calculateComplexPercent(amount, 0.06, period);
            }
            System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
        }

    public static void main(String[] args) {
        new DepositCalculator().doImportantJob();
    }
}