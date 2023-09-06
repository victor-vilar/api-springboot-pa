package com.victorvilar.projetoempresa.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    @Test
    @DisplayName("find the schedule by schedule id")
    void findScheduleSucessfully_WhenPassingValidDayId(){

        Schedule diario = Schedule.getScheduleById(1);
        Schedule semanal = Schedule.getScheduleById(2);

        assertEquals(diario, Schedule.DIARIO);
        assertEquals(semanal, Schedule.SEMANAL);


    }

    @Test
    @DisplayName("find the schedule by schedule name")
    void  findScheduleSucessfully_WhenPassingValidDayName() {

        Schedule diario = Schedule.getScheduleByName("diário");
        Schedule semanal = Schedule.getScheduleByName("semanal");

        assertEquals(diario, Schedule.DIARIO);
        assertEquals(semanal, Schedule.SEMANAL);

    }
}