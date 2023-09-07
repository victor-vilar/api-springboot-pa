package com.victorvilar.projetoempresa.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    @Test
    @DisplayName("find the schedule by schedule id")
    void findScheduleSucessfully_WhenPassingValidDayId(){

        Schedule diario = Schedule.getById(1);
        Schedule semanal = Schedule.getById(2);

        assertEquals(diario, Schedule.DIARIO);
        assertEquals(semanal, Schedule.SEMANAL);


    }

    @Test
    @DisplayName("find the schedule by schedule name")
    void  findScheduleSucessfully_WhenPassingValidDayName() {

        Schedule diario = Schedule.getByName("diário");
        Schedule semanal = Schedule.getByName("semanal");

        assertEquals(diario, Schedule.DIARIO);
        assertEquals(semanal, Schedule.SEMANAL);

    }

    @Test
    @DisplayName("find the schedule id by schedule constant")
    void  findScheduleIdSucessfully_WhenPassingValidScheduleConstant() {

        int diario = Schedule.getEnumId(Schedule.DIARIO);
        int semanal = Schedule.getEnumId(Schedule.SEMANAL);
        int quinzenal = Schedule.getEnumId(Schedule.QUINZENAL);
        int mensal = Schedule.getEnumId(Schedule.MENSAL);
        int sobSolicitacao = Schedule.getEnumId(Schedule.SOB_SOLICITACAO);

        assertEquals(diario,1);
        assertEquals(semanal,2);
        assertEquals(quinzenal,3);
        assertEquals(mensal,4);
        assertEquals(sobSolicitacao,5);


    }
}