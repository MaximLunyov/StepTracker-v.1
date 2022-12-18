public class StepTracker {
    int stepsBasic = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
     class MonthData {
         int[] dayData = new int[30];
     }

    double printDistance(int month) {
        double distance = (printTotalCount(month) * 0.75) / 1000;
        return distance;
    }

    double printCallories(int month) {
        double callories = (printTotalCount(month) * 50) / 1000;
        return callories;
    }
    void saveData(int month, int day, int steps) {
        monthToData[month - 1].dayData[day - 1] = steps;
        if (month == 1) {
            System.out.println("Данные сохранены! Месяц: январь, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 2) {
            System.out.println("Данные сохранены! Месяц: февраль, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 3) {
            System.out.println("Данные сохранены! Месяц: март, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 4) {
            System.out.println("Данные сохранены! Месяц: апрель, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 5) {
            System.out.println("Данные сохранены! Месяц: май, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 6) {
            System.out.println("Данные сохранены! Месяц: июнь, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 7) {
            System.out.println("Данные сохранены! Месяц: июль, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 8) {
            System.out.println("Данные сохранены! Месяц: август, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 9) {
            System.out.println("Данные сохранены! Месяц: сентябрь, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 10) {
            System.out.println("Данные сохранены! Месяц: октябрь, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 11) {
            System.out.println("Данные сохранены! Месяц: ноябрь, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        } else if (month == 12) {
            System.out.println("Данные сохранены! Месяц: декабрь, число: " + day + " Количество пройденных шагов: " + monthToData[month - 1].dayData[day - 1]);
        }
    }

    void printAllSteps(int month) {
        for (int i = 1; i < 31; i++) {
            System.out.println(i + " день: " + monthToData[month - 1].dayData[i - 1]);
        }
    }

    int printMaxCount(int month) {
        int maxCount = 0;
        for (int i = 1; i < 31; i++)
            if (monthToData[month - 1].dayData[i - 1] > maxCount) {
                maxCount = monthToData[month - 1].dayData[i - 1];
        }
        return maxCount;
    }

    int printTotalCount(int month) {
        int totalCount = 0;
        for (int i = 1; i < 31; i++) {
            totalCount = monthToData[month - 1].dayData[i - 1] + totalCount;
        }
        return totalCount;
    }

    double printAvarage(int month) {
        int totalCount = 0;
        for (int i = 1; i < 31; i++) {
            totalCount = monthToData[month - 1].dayData[i - 1] + totalCount;
        }
        int avarageCount = totalCount / 30;
        return avarageCount;
    }

    public int setSteps(int steps) {
        stepsBasic = steps;
        return stepsBasic;
    }
    public int setStepsBasic() {
        return stepsBasic;
    }
    int printBestSeries(int month){
        int stepsByDayStart;
        int bestSeries = 0;
        for (int i = 1; i < 31; i++) {
            stepsByDayStart = monthToData[month - 1].dayData[i - 1];
            if (stepsByDayStart >= stepsBasic) {
                if (i == 1) {
                    bestSeries = bestSeries + 1;
                } else if (monthToData[month - 1].dayData[i - 2] >= stepsBasic) {
                    bestSeries = bestSeries + 1;
                }
            }
        }
        return bestSeries;
    }
}



