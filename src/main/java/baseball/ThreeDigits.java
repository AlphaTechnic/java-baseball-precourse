package baseball;

import java.util.Random;

public class ThreeDigits {
    public String threeDigits = "123";
    public boolean [] IsJudged = new boolean[3];

    public String getThreeDigits() {
        return threeDigits;
    }

    public void genThreeRandomDigits() {
        Random random = new Random();
        boolean [] IsChecked = new boolean[10];

        String ThreeRandomDigits = "";
        int count = 0;
        while (count != 3) {
            int rand = random.nextInt(8) + 1;  // generate 1 ~ 9
            if (!IsChecked[rand]) {
                count++;
                IsChecked[rand] = true;
                ThreeRandomDigits += String.valueOf(rand);
            }
        }

        this.threeDigits = ThreeRandomDigits;
    }

    public int checkStrike(int numberInt) {
        String numberStr = String.valueOf(numberInt);
        int strikeCount = 0;
        for (int i = 0; i < this.threeDigits.length(); i++) {
            if (numberStr.charAt(i) == this.threeDigits.charAt(i)) {
                strikeCount++;
                this.IsJudged[i] = true;
            }
        }
        return strikeCount;
    }

    public int checkBall(int numberInt) {
        String numberStr = String.valueOf(numberInt);
        int ballCount = 0;
        for (int i = 0; i < this.threeDigits.length(); i++) {
            if (this.IsJudged[i]) {
                continue;
            }

            char character = numberStr.charAt(i);
            if (this.threeDigits.indexOf(character) != -1) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
