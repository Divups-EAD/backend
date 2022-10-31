package com.divups.ead.Services;

import com.divups.ead.Entity.BusOwnerEntity;
import com.divups.ead.Model.BusOwner;
import com.divups.ead.Repository.BusOwnerRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusOwnerServiceImpl implements BusOwnerService{

    private final BusOwnerRepository busOwnerRepository;

    public BusOwnerServiceImpl(BusOwnerRepository busOwnerRepository) {
        this.busOwnerRepository = busOwnerRepository;
    }


    @Override
    public List<BusOwner> getAllBusOwner() {
        List<BusOwnerEntity> busOwnerEntities = busOwnerRepository.findAll();

        List<BusOwner> busOwners = busOwnerEntities.stream().map(bowner->new BusOwner(bowner.getBus_owner_id(),
                bowner.getLicense_no(),
                bowner.getTravelsname(),
                bowner.getContact_no())).collect(Collectors.toList());

        return busOwners;
    }

    @Override
    public BusOwner getSBusOwnerById(Integer id) {

        BusOwnerEntity busOwnerEntity = busOwnerRepository.findById(id).get();
        BusOwner busOwner = new BusOwner();
        BeanUtils.copyProperties(busOwnerEntity,busOwner);

        return busOwner;
    }

    @Override
    public BusOwner AddSBusOwner(BusOwner busOwner) {

        BusOwnerEntity busOwnerEntity = new BusOwnerEntity();
        BeanUtils.copyProperties(busOwner,busOwnerEntity);
        busOwnerRepository.save(busOwnerEntity);

        return busOwner;
    }

    @Override
    public BusOwner EditSBusOwner(Integer id, BusOwner busOwner) {

        BusOwnerEntity  busOwnerEntity = busOwnerRepository.findById(id).get();

        busOwnerEntity.setLicense_no(busOwner.getLicense_no());
        busOwnerEntity.setTravelsname(busOwner.getTravelsname());
        busOwnerEntity.setContact_no(busOwner.getContact_no());
        busOwnerRepository.save(busOwnerEntity);

        return busOwner;
    }
}
