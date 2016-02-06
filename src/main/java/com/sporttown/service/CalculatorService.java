package com.sporttown.service;

import com.sporttown.domain.Bill;
import com.sporttown.domain.Data;

/**
 * Created by admin on 03.02.2016.
 */
public interface CalculatorService {
   Bill buildBill(Data data);
}
