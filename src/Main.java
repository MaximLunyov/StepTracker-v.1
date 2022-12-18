import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Приветствуем!");
        StepTracker stepTracker = new StepTracker();

        printMenu:
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                while (true) { // можно переработать для запуска
                    System.out.println("За какой месяц вы хотите внести количество шагов: 1 - январь, 2 - февраль, 3 - март, 4 - апрель, 5 - май, 6 - июнь, 7 - июль, 8 - август, 9 - сентябрь, 10 - октябрь, 11 - ноябрь, 12 - декабрь:");
                    int month = scanner.nextInt();
                    System.out.println("За какое число вы хотите ввести количество шагов: от 1 до 30");
                    int day = scanner.nextInt();
                    System.out.println("Сколько шагов вы прошли?");
                    int steps = scanner.nextInt();
                    if (month > 0 && month < 13 && day > 0 && day < 31 && steps >= 0) {
                        stepTracker.saveData(month, day, steps);
                        break;
                            } else {
                                System.out.println("Ошибка. Некорректно указаны данные! Попробуйте ещё раз.");
                            }
                        }
            } else if (command == 2){
                System.out.println("За какой месяц вы хотите узнать статистику: : 1 - январь, 2 - февраль, 3 - март, 4 - апрель, 5 - май, 6 - июнь, 7 - июль, 8 - август, 9 - сентябрь, 10 - октябрь, 11 - ноябрь, 12 - декабрь:");
                while (true) {
                    int month = scanner.nextInt();
                    if (month > 0 && month < 13) {
                        while (true) {
                            printMenuStat();
                            int commandStat = scanner.nextInt();
                            if (commandStat == 1) {
                                stepTracker.printAllSteps(month);
                                continue;
                            } else if (commandStat == 2) {
                                System.out.println("Общее пройденное количество шагов в этом месяце: " + stepTracker.printTotalCount(month));
                                continue;
                            } else if (commandStat == 3) {
                                System.out.println("Максимальное пройденное количество шагов в этом месяце: " + stepTracker.printMaxCount(month));
                                continue;
                            } else if (commandStat == 4) {
                                System.out.println("Среднее количество пройденных шагов в этом месяце: " + stepTracker.printAvarage(month));
                                continue;
                            } else if (commandStat == 5) {
                                System.out.println("Пройденное растояние в км: " + stepTracker.printDistance(month));
                                continue;
                            } else if (commandStat == 6) {
                                System.out.println("Количество сожжённых килокалорий: " + stepTracker.printCallories(month));
                                continue;
                            } else if (commandStat == 7) {
                                System.out.println("Лучшая серия: " + stepTracker.printBestSeries(month));
                                continue;
                            } else if (commandStat == 8) {
                            continue printMenu;
                        } else {
                                System.out.println("Извините, такой команды пока нет.");
                                continue;
                            }
                        }
                    } else {
                        System.out.println("Ошибка. Введите месяц от 0 до 11:");
                    }
                }
            } else if (command == 3) {
                System.out.println("Текущая цель по шагам в сутки = " + stepTracker.setStepsBasic());
                System.out.println("Введите новую цель: ");
                while (true) {
                    int steps = scanner.nextInt();
                    if (steps >= 0) {
                        System.out.println("Значение сохранено! Новая цель по шагам в сутки = " + stepTracker.setSteps(steps));
                        break;
                    } else {
                        System.out.println("Ошибка. Количество шагов не может быть отрицательным. Введите корректное значение:");
                    }
                }
            } else if (command == 4) {
                System.out.println("Программа завершена.");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Указать количество пройденных шагов за день.");
        System.out.println("2 - Узнать статистику за месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("4 - Выйти из приложения.");
    }
    public static void printMenuStat() {
        System.out.println("Что вы хотите узнать?");
        System.out.println("1 - Статистика по дням.");
        System.out.println("2 - Общее количество шагов за месяц.");
        System.out.println("3 - Максимальное пройденное количество шагов в месяце.");
        System.out.println("4 - Среднее количество шагов.");
        System.out.println("5 - Пройденная дистанция (в км).");
        System.out.println("6 - Количество сожжённых килокалорий.");
        System.out.println("7 - Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.");
        System.out.println("8 - Выход.");
    }
}