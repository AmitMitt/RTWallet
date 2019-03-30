package com.roadTransport.RTWallet.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class GenerateTransactionNumber {

    public static String generateTransactionNumber(){

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = new Date();
        String time  = dateFormat.format(d);
        String hours = null,minutes=null,seconds=null,date=null,month=null,year=null,random=null;
        Random randomNumber = new Random();
        int randomDigit = randomNumber.nextInt(9999);
        String[] timeFormat = time.split(" ");
        String[] currentTime = timeFormat[1].split(":");
        int[] currentTimes = Arrays.stream(currentTime).mapToInt(Integer::parseInt).toArray();

        String[] currentDate = timeFormat[0].split("/");
        int[] currentDates = Arrays.stream(currentDate).mapToInt(Integer::parseInt).toArray();

        hours = String.format("%02d", currentTimes[0]);
        minutes = String.format("%02d", currentTimes[1]);
        seconds = String.format("%02d", currentTimes[2]);
        date = String.format("%03d", currentDates[0]);
        month = String.format("%03d", currentDates[1]);
        year = String.format("%04d", currentDates[2]);
        random = String.format("%04d", randomDigit);

        String transactionNumber = hours+minutes+seconds+date+month+year+random;
        return transactionNumber;
    }

}
