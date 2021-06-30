package com.example.data;

import com.example.constraintlayout.R;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class FakeDataUtils {

    public static BoardingPassInfo generateFakeBoardingPassInfo(){
        String passengerName = "Mr. RANDOM PERSON";
        String flightCode = "UD 777";
        String originCode = "JFK";
        String destCode = "PAT";

        long now = System.currentTimeMillis();

        long randomMinutesUntilBoarding = (long)(Math.random() * 30);

        long totalBoardingMinutes = 40;
        long randomFlightLengthHours = (long)(Math.random() * 5 + 1);

        long boardingStartAt = now + minutesToMillis( randomMinutesUntilBoarding);
        long departure = boardingStartAt + minutesToMillis(totalBoardingMinutes);
        long arrival = departure + hoursToMillis(randomFlightLengthHours);

        Timestamp boardingMillis = new Timestamp(boardingStartAt);
        Timestamp departureTime = new Timestamp(departure);
        Timestamp arrivalTime = new Timestamp(arrival);

        String departureGate = "3C";
        String departureTerminal = "3A";
        String seatNumber = "45A";

        int barCodeImageRes = R.drawable.art_plane;

        return new BoardingPassInfo(
                passengerName,
                flightCode,
                originCode,
                destCode,
                boardingMillis,
                departureTime,
                arrivalTime,
                departureTerminal,
                departureGate,
                seatNumber,
                barCodeImageRes);
        }

    private static long hoursToMillis(long randomFlightLengthHours) {
        return TimeUnit.HOURS.toMillis(randomFlightLengthHours);
    }

    private static long minutesToMillis(long randomMinutesUntilBoarding) {
        return TimeUnit.MINUTES.toMillis(randomMinutesUntilBoarding);
    }
}
