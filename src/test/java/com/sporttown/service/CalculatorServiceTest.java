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
        data.addService(new Service.ServiceBuilder().setNames(ServiceName.SAYNA).build());
        data.setClient(new Client.ClientBuilder().makeNameSurname("ASD aza").makeTown("Lviv")
                .makeDateOfBirth(LocalDate.ofEpochDay(2001-01-01)).makeDateOfEnter(LocalDate.ofEpochDay(2001-01-01)).makeSex(Sex.MALE).makeLevel(false).build());
        Bill bill = calculatorService.buildBill(data);
        data.setTnow(LocalDate.ofEpochDay(2015 - 03 - 15));
        Assert.assertEquals(760, bill.getSummaryPrice());
    }

    @Test
    public void testCalcSerForBodyBuilderSlippers() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        data.addService(new Service.ServiceBuilder().setNames(ServiceName.SLIPPERS).build());
        data.setClient(new Client.ClientBuilder().makeNameSurname("ASD aza").makeTown("Lviv")
                .makeDateOfBirth(LocalDate.ofEpochDay(2001-01-01)).makeDateOfEnter(LocalDate.ofEpochDay(2001-01-01)).makeSex(Sex.MALE).makeLevel(false).build());
        Bill bill = calculatorService.buildBill(data);
        data.setTnow(LocalDate.ofEpochDay(2015 - 03 - 15));
        Assert.assertEquals(760, bill.getSummaryPrice());
    }

    @Test
    public void testCalcSerForBodyBuilderTowel() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        data.addService(new Service.ServiceBuilder().setNames(ServiceName.TOWEL).build());
        data.setClient(new Client.ClientBuilder().makeNameSurname("ASD aza").makeTown("Lviv")
                .makeDateOfBirth(LocalDate.ofEpochDay(2001-01-01)).makeDateOfEnter(LocalDate.ofEpochDay(2001-01-01)).makeSex(Sex.MALE).makeLevel(false).build());
        Bill bill = calculatorService.buildBill(data);
        data.setTnow(LocalDate.ofEpochDay(2015 - 03 - 15));
        Assert.assertEquals(760, bill.getSummaryPrice());
    }

    @Test
    public void testCalcSerForBodyBuilderMassage() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        data.addService(new Service.ServiceBuilder().setNames(ServiceName.MASSAGE).build());
        data.setClient(new Client.ClientBuilder().makeNameSurname("ASD aza").makeTown("Lviv")
                .makeDateOfBirth(LocalDate.ofEpochDay(2001-01-01)).makeDateOfEnter(LocalDate.ofEpochDay(2001-01-01)).makeSex(Sex.MALE).makeLevel(false).build());
        Bill bill = calculatorService.buildBill(data);
        data.setTnow(LocalDate.ofEpochDay(2015 - 03 - 15));
        Assert.assertEquals(760, bill.getSummaryPrice());
    }

    @Test
    public void testCalcSerForTenYearSportsmen() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        data.addService(new Service.ServiceBuilder().setNames(ServiceName.GYMTRAINER12).build());
        data.setClient(new Client.ClientBuilder().makeNameSurname("ASD aza").makeTown("Lviv")
                .makeDateOfBirth(LocalDate.ofEpochDay(2001-01-01)).makeDateOfEnter(LocalDate.ofEpochDay(2001-01-01)).makeSex(Sex.MALE).makeLevel(false).build());
        Bill bill = calculatorService.buildBill(data);
        data.setTnow(LocalDate.ofEpochDay(2015 - 03 - 15));
        Assert.assertEquals(760, bill.getSummaryPrice());

    }

    @Test
    public void testCalculationServiceImplForInternationalWomenDay() {

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        data.addService(new Service.ServiceBuilder().setNames(ServiceName.GYMFORONETIME).build());
        data.setClient(new Client.ClientBuilder().makeNameSurname("ASD aza").makeTown("Lviv")
                .makeDateOfBirth(LocalDate.ofEpochDay(2001-01-01)).makeDateOfEnter(LocalDate.ofEpochDay(2015-01-01)).makeSex(Sex.FEMALE).makeLevel(false).build());
        data.setTnow(LocalDate.ofEpochDay(2015 - 03 - 8));
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, bill.getSummaryPrice());

    }

    @Test
    public void testCalculationServiceImplForDayOfDefender() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        data.addService(new Service.ServiceBuilder().setNames(ServiceName.GYMFORONETIME).build());
        data.setClient(new Client.ClientBuilder().makeNameSurname("ASD aza").makeTown("Lviv")
                .makeDateOfBirth(LocalDate.ofEpochDay(2001-01-01)).makeDateOfEnter(LocalDate.ofEpochDay(2015-01-01)).makeSex(Sex.MALE).makeLevel(false).build());
        data.setTnow(LocalDate.ofEpochDay(2015 - 10 - 14));
        Bill bill = calculatorService.buildBill(data);
        Assert.assertEquals(0.0, bill.getSummaryPrice());
    }
}

