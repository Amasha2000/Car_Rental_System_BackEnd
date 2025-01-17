package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.DriverScheduleDTO;

import java.util.ArrayList;

public interface DriverScheduleService {
    void addDriverSchedule(DriverScheduleDTO dto);

    String getLastId();

    ArrayList<DriverScheduleDTO> getAll();

    void updateSchedule(DriverScheduleDTO dto);

    void deleteSchedule(String id);

    ArrayList<DriverScheduleDTO> getScheduleById(String id);
}
