package com.divups.ead.Services;

import com.divups.ead.Model.SpecialHire;

import java.util.List;

public interface RequestService {

    List<SpecialHire> getAllRequests();
    SpecialHire getRequestById(Integer id);
    SpecialHire AddRequest(SpecialHire specialHire);
    SpecialHire EditRequestStatus(Integer id,SpecialHire specialHire);

}
