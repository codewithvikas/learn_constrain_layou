package com.example.data;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class BoardingPassInfo {

    private String passengerName;

    private String flightCode;
    private String originCode;
    private String destinationCode;

    private Timestamp boardingTime;
    private Timestamp departureTime;
    private Timestamp arrivalTime;

    private String departureTerminal;
    private String departureGate;
    private String seatNumber;

    private int barCodeImageResource;

    public BoardingPassInfo(String passengerName, String flightCode, String originCode, String destinationCode, Timestamp boardingTime, Timestamp departureTime, Timestamp arrivalTime, String departureTerminal, String departureGate, String seatNumber, int barCodeImageResource) {
        this.passengerName = passengerName;
        this.flightCode = flightCode;
        this.originCode = originCode;
        this.destinationCode = destinationCode;
        this.boardingTime = boardingTime;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureTerminal = departureTerminal;
        this.departureGate = departureGate;
        this.seatNumber = seatNumber;
        this.barCodeImageResource = barCodeImageResource;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public String getOriginCode() {
        return originCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public Timestamp getBoardingTime() {
        return boardingTime;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public String getDepartureGate() {
        return departureGate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public int getBarCodeImageResource() {
        return barCodeImageResource;
    }

    public long getMinutesUntilBoarding(){
        long millisUntilBoarding = boardingTime.getTime() - System.currentTimeMillis();
        return TimeUnit.MICROSECONDS.toMinutes(millisUntilBoarding);
    }
}
