package com.divups.ead.Services;

import com.divups.ead.Model.SpecialBus;

import java.util.List;

public interface SpecialBusService {

    List<SpecialBus> getAllSpecialBuses();
    SpecialBus getSBusById(Integer id);
    SpecialBus AddSBus(SpecialBus specialBus);
    SpecialBus EditSBus(Integer id, SpecialBus specialBus);
    Boolean SBusDeleted(Integer id);
}
