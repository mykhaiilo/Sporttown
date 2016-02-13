package com.sporttown;

import com.sporttown.domain.Bill;
import com.sporttown.domain.Data;
import com.sporttown.service.CalculatorServiceImpl;
import com.sporttown.service.UserDialogServiceImpl;

/**
 * Created by admin on 24.01.2016.
 */
public class Launcher {
    public static void main(String[] args) {
        CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();
        UserDialogServiceImpl userDialogServiceImpl = calculatorServiceImpl.getUserDialogService();

        Data data = userDialogServiceImpl.readData();
        calculatorServiceImpl.sum();
        calculatorServiceImpl.discount();
        Bill bill = calculatorServiceImpl.buildBill(data);
        System.out.println(calculatorServiceImpl.getSum());

        System.out.println(bill);

    }
}
