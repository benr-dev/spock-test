package org.example;

public class BowlingGame {
    private int[] scorecard = new int[21];
    private int rollNumber = 0;

    public void roll(int... pinsDown) {
        for(int i : pinsDown) {
            scorecard[rollNumber++] = i;
        }
    }

    public int getScore() {
        int sum = 0;
        int rollNumber = 0;

        for(int frame = 1; frame <= 10; frame++) {
            if(isAStrike(rollNumber)) {
                sum += getStrikeFrameScore(rollNumber);
                rollNumber += 1;
            }
            else if(isASpare(rollNumber)) {
                sum += getSpareFrameScore(rollNumber);
                rollNumber += 2;
            }
            else {
                sum += getRegularFrameScore(rollNumber);
                rollNumber += 2;
            }
        }

        return sum;
    }

    private boolean isASpare(int rollNumber) {
        return getRegularFrameScore(rollNumber) == 10;
    }

    private boolean isAStrike(int rollNumber) {
        return scorecard[rollNumber] == 10;
    }

    private int getRegularFrameScore(int rollNumber) {
        return scorecard[rollNumber] + scorecard[rollNumber + 1];
    }

    private int getSpareFrameScore(int rollNumber) {
        return 10 + scorecard[rollNumber + 2];
    }

    private int getStrikeFrameScore(int rollNumber) {
        return 10 + getRegularFrameScore(rollNumber + 1);
    }

}
