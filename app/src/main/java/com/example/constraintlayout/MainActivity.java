package com.example.constraintlayout;

import androidx.activity.result.ActivityResultRegistry;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.constraintlayout.databinding.ActivityMainBinding;
import com.example.data.BoardingPassInfo;
import com.example.data.FakeDataUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        bindData();

    }

    private void bindData() {

        BoardingPassInfo boardingPassInfo = FakeDataUtils.generateFakeBoardingPassInfo();

        activityMainBinding.passengerNameTv.setText(boardingPassInfo.getPassengerName());

        activityMainBinding.flightCodeTv.setText(boardingPassInfo.getFlightCode());
        activityMainBinding.srcCodeTv.setText(boardingPassInfo.getOriginCode());
        activityMainBinding.dstCodeTv.setText(boardingPassInfo.getDestinationCode());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:a", Locale.getDefault());

        String boardingTime = simpleDateFormat.format(boardingPassInfo.getBoardingTime());
        String arrivalTime = simpleDateFormat.format(boardingPassInfo.getArrivalTime());
        String departureTime = simpleDateFormat.format(boardingPassInfo.getDepartureTime());

        activityMainBinding.boardingTimeTv.setText(boardingTime);
        activityMainBinding.arrivalTimeTv.setText(arrivalTime);
        activityMainBinding.departureTimeTv.setText(departureTime);


        activityMainBinding.textViewGate.setText(boardingPassInfo.getDepartureGate());
        activityMainBinding.textViewSeat.setText(boardingPassInfo.getSeatNumber());
        activityMainBinding.textViewTerminal.setText(boardingPassInfo.getDepartureTerminal());

        long totalMinutesUntilBoarding = boardingPassInfo.getMinutesUntilBoarding();
        long hoursUntilBoarding = TimeUnit.MINUTES.toHours(totalMinutesUntilBoarding);
        long minutesLessHoursUntilBoarding = TimeUnit.HOURS.toMinutes(hoursUntilBoarding);

        String hoursAndMinutesUntilBoarding = getString(R.string.countDownFormat,hoursUntilBoarding,minutesLessHoursUntilBoarding);
        activityMainBinding.boardingInTv.setText(hoursAndMinutesUntilBoarding);

    }
}