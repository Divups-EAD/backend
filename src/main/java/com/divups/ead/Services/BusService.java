package com.divups.ead.Services;

import com.divups.ead.Model.Bus;

import java.util.List;

public interface BusService {

    List<Bus> getAllBuses();
    Bus getBusById(Integer id);
    Bus AddBus(Bus bus);
    Bus EditBus(Integer id, Bus bus);
    Boolean BusDeleted(Integer id);
}
