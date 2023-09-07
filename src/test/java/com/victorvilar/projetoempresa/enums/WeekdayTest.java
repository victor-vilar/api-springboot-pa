package com.victorvilar.projetoempresa.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test of weekday constant
 */
class WeekdayTest {

    @Test
    @DisplayName("find the weekday constant when passing the weekday id")
    public void findWeekdaySucessfully_WhenPassingValidDayId(){

        Weekday segunda = Weekday.getByDay(2);
        Weekday terca = Weekday.getByDay(3);
        assertEquals(segunda,Weekday.SEGUNDA);
        assertEquals(terca,Weekday.TERCA);


    }

    @Test
    @DisplayName("find the weekday constant when passing the weekday day name")
    public void findWeekdaySucessfully_WhenPassingValidDayName(){

        Weekday segunda = Weekday.getByName("segunda-feira");
        Weekday terca = Weekday.getByName("terça-feira");
        assertEquals(segunda,Weekday.SEGUNDA);
        assertEquals(terca,Weekday.TERCA);


    }

    @Test
    @DisplayName("find the weekday id when passing a weekday constant")
    public void findWeekdayIdSucessfully_WhenPassingValidWeekdayConstant(){

        int domingo = Weekday.getEnumId(Weekday.DOMINGO);
        int segunda = Weekday.getEnumId(Weekday.SEGUNDA);
        int terca = Weekday.getEnumId(Weekday.TERCA);
        int quarta = Weekday.getEnumId(Weekday.QUARTA);
        int quinta = Weekday.getEnumId(Weekday.QUINTA);
        int sexta = Weekday.getEnumId(Weekday.SEXTA);
        int sabado = Weekday.getEnumId(Weekday.SABADO);

        assertEquals(domingo, 1);
        assertEquals(segunda, 2);
        assertEquals(terca, 3);
        assertEquals(quarta, 4);
        assertEquals(quinta, 5);
        assertEquals(sexta, 6);
        assertEquals(sabado, 7);


    }



}