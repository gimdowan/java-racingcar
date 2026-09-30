package racingcar;

import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 쉼표로 구분해 입력: ");
        String line = sc.nextLine();
        String[] names = line.split(",");
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        int play = sc.nextInt();
        for (int i = 0; i < play; i++) {
            for (int j = 0; j < names.length; j++) {
                int num = Randoms.pickNumberInRange(0, 9);
                if (num >= 4) {
                    tracks[j] += "-";
                }


            }
            for (int j = 0; j < names.length; j++) {
                System.out.println(names[j].trim() + " : " + tracks[j]);
            }
            System.out.println();
            sc.close();
        }
        int max = -1;
        String winners = "";
        for (int j = 0; j < names.length; j++) {
            int len = tracks[j].length();
            if (len > max) {
                max = len;
                winners = names[j].trim();          // 새 1등 → 우승자를 이 사람으로 교체
            } else if (len == max) {
                winners += ", " + names[j].trim();  // 공동 1등 → 뒤에 이어 붙이기
            }
        }
        System.out.println("최종 우승자 : " + winners);

    }
}
