package com.divups.ead.Services;

import com.divups.ead.Entity.SpecialHireEntity;
import com.divups.ead.Model.SpecialHire;
import com.divups.ead.Repository.SpecialHireRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService{

    final SpecialHireRepository specialHireRepository;

    public RequestServiceImpl(SpecialHireRepository specialHireRepository) {
        this.specialHireRepository = specialHireRepository;
    }


    @Override
    public List<SpecialHire> getAllRequests() {

        List<SpecialHireEntity> specialHireEntities = specialHireRepository.findAll();

        List<SpecialHire> specialHires = specialHireEntities.stream().map(requests -> new SpecialHire(requests.getSpecialbooking_id(),
                requests.getStart(),
                requests.getDestination(),
                requests.getNo_of_days(),
                requests.getCustomer_contact(),
                requests.getHire_date(),
                requests.getRequest_status(),
                requests.getSpecial_notes(),
                requests.getRequest_on())).collect(Collectors.toList());

        return specialHires;
    }


    @Override
    public SpecialHire getRequestById(Integer id) {
        SpecialHireEntity specialHireEntity = specialHireRepository.findById(id).get();

        SpecialHire specialHire = new SpecialHire();
        BeanUtils.copyProperties(specialHireEntity,specialHire);

        return specialHire;
    }

    @Override
    public SpecialHire AddRequest(SpecialHire specialHire) {

        SpecialHireEntity specialHireEntity = new SpecialHireEntity();
        BeanUtils.copyProperties(specialHire,specialHireEntity);
        specialHireRepository.save(specialHireEntity);

        return specialHire;
    }


    @Override
    public SpecialHire EditRequestStatus(Integer id, SpecialHire specialHire) {

        SpecialHireEntity specialHireEntity = specialHireRepository.findById(id).get();
        specialHireEntity.setRequest_status(Boolean.TRUE);
        specialHireRepository.save(specialHireEntity);

        return specialHire;
    }
}
