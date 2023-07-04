package com.victorvilar.projetoempresa.domain.bill;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

/**
 * Represents a bill of something that is recurrent.
 * save the bills that need to be paid from time to time,
 * So one time a year the system will check all frequent bills
 * that have to be paid and emit a DefaultBill with the same information.
 *
 * If a bill its paid yearlly(anual) so it will create a DefaultBill with
 * all the information of a FrequentBill plus month and day of the payment
 *
 * If a FrequentBill its paid by month(mensal), the system will creates 12
 * DefaultBills with the information of a FrequentBill and the day of the payment.
 *
 *
 */
public class FrequentBill extends Bill {

    @Enumerated(EnumType.STRING)
    private BillFrequency billFrequency;



}
