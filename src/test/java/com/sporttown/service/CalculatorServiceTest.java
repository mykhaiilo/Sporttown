package com.sporttown.service;

import com.sporttown.domain.Bill;
import com.sporttown.domain.Client;
import com.sporttown.domain.Data;
import com.sporttown.domain.Service;
import com.sporttown.domain.ServiceName;
import com.sporttown.domain.Sex;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class CalculatorServiceTest {


    @Test
    public void testCalcSerForBodyBuilderSayna() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();

        data.getServices().add(new Service());
        //data.getServices().get(0).setName(ServiceName.SAYNA);
        data.setClient(new Client());
        data.getClient().setIsProffecional("YES");
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, bill.getSummaryPrice());
    }

    @Test
    public void testCalcSerForBodyBuilderSlippers() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();

        data.getServices().add(new Service());
        //data.getServices().get(0).setName(ServiceName.SLIPPERS);
        data.setClient(new Client());
        data.getClient().setIsProffecional("YES");
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, bill.getSummaryPrice());
    }

    @Test
    public void testCalcSerForBodyBuilderTowel() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();

        data.getServices().add(new Service());
      //  data.getServices().get(0).setName(ServiceName.TOWEL);
        data.setClient(new Client());
        data.getClient().setIsProffecional("YES");
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, bill.getSummaryPrice());
    }

    @Test
    public void testCalcSerForBodyBuilderMassage() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();

        data.getServices().add(new Service());
    //    data.getServices().get(0).setName(ServiceName.MASSAGE);
        data.setClient(new Client());
        data.getClient().setIsProffecional("YES");
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, bill.getSummaryPrice());
    }

    @Test
    public void testCalcSerForTenYearSportsmen() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();

        data.getServices().add(new Service());
  //      data.getServices().get(0).setName(ServiceName.GYMFORONETIME);
        data.setClient(new Client());
        data.getClient().setDateOfEnter(LocalDate.ofEpochDay(1990-01-01));
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(95.0, bill.getSummaryPrice());

    }

    @Test
    public void testCalculationServiceImplForInternationalWomenDay() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        Service service= new Service.ServiceBuilder().setNames(ServiceName.GYMFORONETIME).build();
        //data.getServices().add(new Service());
        //data.getServices().get(0).setName(ServiceName.GYMFORONETIME);
        data.addService(service);
        data.setClient(new Client());
        data.getClient().setSex(Sex.FEMALE);
        data.setTnow(LocalDate.ofEpochDay(2015 - 03 - 8));
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, bill.getSummaryPrice());

    }

    @Test
    public void testCalculationServiceImplForDayOfDefender() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();

        data.getServices().add(new Service());
//        data.getServices().get(0).setName(ServiceName.GYMFORONETIME);
        data.setClient(new Client());
        data.getClient().setSex(Sex.MALE);
        data.setTnow(LocalDate.ofEpochDay(2015 - 03 - 8));
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, bill.getSummaryPrice());
    }
}

