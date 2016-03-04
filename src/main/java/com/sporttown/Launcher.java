package com.sporttown;

import com.sporttown.domain.Bill;
import com.sporttown.domain.Data;
import com.sporttown.service.CalculatorServiceImpl;
import com.sporttown.service.UserDialogServiceImpl;


public class Launcher {
    public static void main(String[] args) {


        CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();
        UserDialogServiceImpl userDialogServiceImpl = new UserDialogServiceImpl();
        Data data = userDialogServiceImpl.readData();
        Bill bill = calculatorServiceImpl.buildBill(data);
        System.out.println(bill);

    }

}