package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Cars {
    private Car[] cars;

    public Cars(String[] names) {
        cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    public void moveAll() {
        for (int j = 0; j < cars.length; j++) {
            int num = Randoms.pickNumberInRange(0, 9);
            cars[j].move(num);
        }
    }

    public void printPositions() {
        for (int j = 0; j < cars.length; j++) {
            System.out.println(cars[j].getName() + " : " + "-".repeat(cars[j].getPosition()));
        }
        System.out.println();
    }

    public String getWinners() {
        int max = -1;
        String winners = "";
        for (int j = 0; j < cars.length; j++) {
            int position = cars[j].getPosition();
            if (position > max) {
                max = position;
                winners = cars[j].getName();          // 새 1등 → 우승자를 이 사람으로 교체
            } else if (position == max) {
                winners += ", " + cars[j].getName();  // 공동 1등 → 뒤에 이어 붙이기
            }
        }
        return winners;
    }
}
