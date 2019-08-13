import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
//        Write a program that simulates a random fortune from a fortune cookie. You must have at least six fortunes.

        String[] randomFortune =
                {
                        "Adversity is the parent of virtue.",
                        "Accept yourself",
                        "A friend asks only for your time not your money.",
                        "You may be disappointed if you fail, but you are doomed if you don't try.",
                        "Compassion will cure more then condemnation.",
                        "You will be rewarded for your patience and understanding."
                };


        int randomNumber = randomGenerator.nextInt(randomFortune.length);
        System.out.println("Fortune cookie says: " + randomFortune[randomNumber]);

//        Fortune cookie says:

//For bonus points, also add randomly-chosen lotto numbers to the fortune. In Texas, the lotto chooses 6 numbers, each from 1-54.
        int randomFortuneNum1 = randomGenerator.nextInt(54) + 1;
        int randomFortuneNum2 = randomGenerator.nextInt(54) + 1;
        int randomFortuneNum3 = randomGenerator.nextInt(54) + 1;
        int randomFortuneNum4 = randomGenerator.nextInt(54) + 1;
        int randomFortuneNum5 = randomGenerator.nextInt(54) + 1;
        int randomFortuneNum6 = randomGenerator.nextInt(54) + 1;

        System.out.println(randomFortuneNum1 + "-" +  randomFortuneNum2 + "-" + randomFortuneNum3 + "-"
                + randomFortuneNum4 + "-" + randomFortuneNum5 + "-" + randomFortuneNum6);
    }
}
