package com.victorvilar.projetoempresa.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test of weekday constant
 */
class WeekdayTest {

    @Test
    @DisplayName("find the weekday constant when passing the weekday id")
    public void findWeekdaySucessfully_WhenPassingValidDayId(){

        Weekday segunda = Weekday.getWeekdayByDay(2);
        Weekday terca = Weekday.getWeekdayByDay(3);
        assertEquals(segunda,Weekday.SEGUNDA);
        assertEquals(terca,Weekday.TERCA);


    }

    @Test
    @DisplayName("find the weekday constant when passing the weekday day name")
    public void findWeekdaySucessfully_WhenPassingValidDayName(){

        Weekday segunda = Weekday.getWeekdayByName("segunda-feira");
        Weekday terca = Weekday.getWeekdayByName("terça-feira");
        assertEquals(segunda,Weekday.SEGUNDA);
        assertEquals(terca,Weekday.TERCA);


    }



}