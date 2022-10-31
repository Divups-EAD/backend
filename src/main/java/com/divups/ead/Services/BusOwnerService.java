package com.divups.ead.Services;

import com.divups.ead.Model.BusOwner;
import java.util.List;

public interface BusOwnerService {

    List<BusOwner> getAllBusOwner();
    BusOwner getSBusOwnerById(Integer id);
    BusOwner AddSBusOwner(BusOwner busOwner);
    BusOwner EditSBusOwner(Integer id, BusOwner busOwner);
//    Boolean SBusDeleted(Integer id);
}
