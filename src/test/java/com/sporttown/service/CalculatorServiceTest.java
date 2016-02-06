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
    public void testCalculationServiceImplForBodyBuilder() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Data data = new Data();
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
