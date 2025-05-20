import java.math.BigInteger;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class LargeNumberAddition {

    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println("Started at: " + start.atZone(ZoneId.of("Europe/Paris")));

        long counter = 0;

        BigInteger sum = BigInteger.ZERO;
        BigInteger currentNmber = BigInteger.ONE;

        while (true){

            sum = sum.add(currentNmber);
            currentNmber = currentNmber.add(BigInteger.ONE);

            counter++;
            if (counter == 10_000_000_000L){
                long secondsPassed = Instant.now().getEpochSecond() - start.getEpochSecond();

                System.out.println("Next 10_000_000_000 numbers were adeed, sum now is " + sum + " current number is: " + currentNmber);
                System.out.printf("%s -> Application running for %.2f minutes%n", Instant.now().atZone(ZoneId.of("Europe/Paris")), (secondsPassed / 60.0));

                counter = 0;
            }

        }
    }
}
