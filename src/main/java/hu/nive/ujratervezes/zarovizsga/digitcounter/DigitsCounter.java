package hu.nive.ujratervezes.zarovizsga.digitcounter;

public class DigitsCounter {


    public int getCountOfDigits(String s) {
        int sum = 0;
        int[] sumArray = new int[10];
        if (s != null && !s.isBlank()) {
            collectDigits(s, sumArray);
            sum = countOfDigits(sum, sumArray);
        }
        return sum;
    }

    private int countOfDigits(int sum, int[] sumArray) {
        for (Integer i : sumArray) {
            if (i == 1) {
                sum++;
            }
        }
        return sum;
    }

    private void collectDigits(String s, int[] sumArray) {
        for (int i = 0; i < s.length(); i++) {
            String character = Character.toString(s.charAt(i));
            if ("0123456789".contains(character)) {
                sumArray[Integer.parseInt(character)] = 1;
            }
        }
    }
}
