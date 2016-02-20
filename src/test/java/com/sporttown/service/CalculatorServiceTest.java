package com.sporttown.service;

import com.sporttown.domain.Bill;
import com.sporttown.domain.Data;
import com.sporttown.domain.Service;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by admin on 06.02.2016.
 */
public class CalculatorServiceTest {

    @Test
    //тестувати професіонала
    //тест >10 років
    //тест жінки
    //тест чоловіка
    public void testCalculationServiceImplForBodyBuilder() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
        data.setClient(null);
        data.setServices(null);
        Bill bill = calculatorService.buildBill(data);
        List<Service> list = bill.getListOfServices();
        for (Service service : list
                ) {
            /*if (service.getName().equals(Enum)) {
                Assert.assertEquals(service.getPrice(), 0);
            }
        }*/

        }
    }
}
