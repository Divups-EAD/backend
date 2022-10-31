package com.divups.ead.Services;

import com.divups.ead.Entity.SpecialBusEntity;
import com.divups.ead.Model.SpecialBus;
import com.divups.ead.Repository.SpecialBusRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialBusServiceImpl implements SpecialBusService{

    private final SpecialBusRepository specialBusRepository;

    public SpecialBusServiceImpl(SpecialBusRepository specialBusRepository) {
        this.specialBusRepository = specialBusRepository;
    }


    //listing all special buses
    @Override
    public List<SpecialBus> getAllSpecialBuses() {
        List<SpecialBusEntity> specialBusEntities = specialBusRepository.findAll();
        List<SpecialBus> specialBuses = specialBusEntities.stream().map(sbus-> new SpecialBus(sbus.getSpecial_hiring_id(),
                sbus.getNo_of_seats(),
                sbus.getPayment_rate(),
                sbus.getFacillities(),
                sbus.getContact_no(),
                sbus.getFacebook_link(),
                sbus.getInsta_link(),
                sbus.getBus_name(),
                sbus.getSpecialbus_type(),
                sbus.getSpecialbus_added()
                )).collect(Collectors.toList());

        return specialBuses;
    }


    //listing single
    @Override
    public SpecialBus getSBusById(Integer id) {

        SpecialBusEntity specialBusEntity = specialBusRepository.findById(id).get();
        SpecialBus specialBus = new SpecialBus();
        BeanUtils.copyProperties(specialBusEntity,specialBus);

        return specialBus;
    }


    //adding a special bus
    @Override
    public SpecialBus AddSBus(SpecialBus specialBus) {

        SpecialBusEntity specialBusEntity = new SpecialBusEntity();
        BeanUtils.copyProperties(specialBus,specialBusEntity);
        specialBusRepository.save(specialBusEntity);

        return specialBus;
    }


    //Edit added bus
    @Override
    public SpecialBus EditSBus(Integer id, SpecialBus specialBus) {

        SpecialBusEntity specialBusEntity = specialBusRepository.findById(id).get();

        specialBusEntity.setNo_of_seats(specialBus.getNo_of_seats());
        specialBusEntity.setPayment_rate(specialBus.getPayment_rate());
        specialBusEntity.setFacillities(specialBus.getFacillities());
        specialBusEntity.setContact_no(specialBus.getContact_no());
        specialBusEntity.setFacebook_link(specialBus.getFacebook_link());
        specialBusEntity.setInsta_link(specialBus.getInsta_link());
        specialBusEntity.setBus_name(specialBus.getBus_name());
        specialBusEntity.setSpecialbus_type(specialBus.getSpecialbus_type());
        specialBusRepository.save(specialBusEntity);

        return specialBus;
    }

    // deleting a bus
    @Override
    public Boolean SBusDeleted(Integer id){
        try {
            SpecialBusEntity specialBusEntity=specialBusRepository.findById(id).get();
            specialBusRepository.delete(specialBusEntity);
            return true;
        }catch (Exception BusNotFound ){
            return false;
        }
    }

}
