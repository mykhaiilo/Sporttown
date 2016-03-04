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
import java.util.ArrayList;
import java.util.List;

public class CalculatorServiceTest {


    @Test
    public void testCalcSerForBodyBuilderSayna() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        Service service = new Service();
        service.setName(ServiceName.SAYNA);
        List<Service> list = new ArrayList<>();
        list.add(service);
        data.setClient(new Client());
        Client client = new Client();
        client.setIsProffecional("YES");
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, calculatorService.getSum());
    }

    @Test
    public void testCalcSerForBodyBuilderSlippers() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        Service service = new Service();
        service.setName(ServiceName.SLIPPERS);
        List<Service> list = new ArrayList<>();
        list.add(service);
        data.setClient(new Client());
        Client client = new Client();
        client.setIsProffecional("YES");
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, calculatorService.getSum());
    }

    @Test
    public void testCalcSerForBodyBuilderTowel() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        Service service = new Service();
        service.setName(ServiceName.TOWEL);
        List<Service> list = new ArrayList<>();
        list.add(service);
        data.setClient(new Client());
        Client client = new Client();
        client.setIsProffecional("YES");
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, calculatorService.getSum());
    }

    @Test
    public void testCalcSerForBodyBuilderMassage() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        Service service = new Service();
        service.setName(ServiceName.MASSAGE);
        List<Service> list = new ArrayList<>();
        list.add(service);
        data.setClient(new Client());
        Client client = new Client();
        client.setIsProffecional("YES");
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, calculatorService.getSum());
    }

    @Test
    public void testCalcSerForTenYearSportsmen() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        Service service = new Service();
        List<Service> list = new ArrayList<>();
        list.add(service);
        service.setName(ServiceName.FRESH);
        data.setClient(new Client());
        Client client = new Client();
        client.setDateOfEnter(LocalDate.ofEpochDay(1990 - 01 - 01));
        calculatorService.setSum(95);
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(95.0, calculatorService.getSum());

    }

    @Test
    public void testCalculationServiceImplForWomenDay() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        Service service = new Service();
        service.setName(ServiceName.SAYNA);
        List<Service> list = new ArrayList<>();
        list.add(service);
        data.setClient(new Client());
        Client client = new Client();
        calculatorService.setTnow(LocalDate.ofEpochDay(2015 - 03 - 8));
        client.setSex(Sex.FEMALE);
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, calculatorService.getSum());
    }

    @Test
    public void testCalculationServiceImplForMenDay() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        Service service = new Service();
        service.setName(ServiceName.SAYNA);
        List<Service> list = new ArrayList<>();
        list.add(service);
        data.setClient(new Client());
        Client client = new Client();
        calculatorService.setTnow(LocalDate.ofEpochDay(2015 - 10 - 20));
        client.setSex(Sex.MALE);
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, calculatorService.getSum());
    }
}

