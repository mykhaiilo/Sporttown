package com.sporttown.service;

import com.sporttown.domain.Bill;
import com.sporttown.domain.Data;

public interface CalculatorService {
   Bill buildBill(Data data);
}
