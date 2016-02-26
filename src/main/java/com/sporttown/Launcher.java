package com.sporttown;

import com.sporttown.domain.Bill;
import com.sporttown.domain.Data;
import com.sporttown.service.CalculatorServiceImpl;
import com.sporttown.service.UserDialogServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Launcher {
    public static void main(String[] args) {
        CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();
        UserDialogServiceImpl userDialogServiceImpl = new UserDialogServiceImpl();

        Data data = userDialogServiceImpl.readData();
        Bill bill = calculatorServiceImpl.buildBill(data);
        Logger logger = LoggerFactory.getLogger(Launcher.class);
        logger.info("Launcher");
        System.out.println(bill);

    }
}
