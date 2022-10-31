package com.divups.ead.Services;

import com.divups.ead.Entity.BusEntity;
import com.divups.ead.Model.Bus;
import com.divups.ead.Repository.BusRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }


    @Override
    public List<Bus> getAllBuses() {
        List<BusEntity> busEntities = busRepository.findAll();

        List<Bus> buses = busEntities.stream().map(bus1 -> new Bus(bus1.getBus_id(),
                bus1.getStart_point(),
                bus1.getEnd_point(),
                bus1.getBus_type(),
                bus1.getStatus(),
                bus1.getNo_of_seats(),
                bus1.getRate(),
                bus1.getAdded_on()
                )).collect(Collectors.toList());

        return buses;
    }


    @Override
    public Bus getBusById(Integer id) {

        BusEntity busEntity= busRepository.findById(id).get();
        Bus bus = new Bus();

        BeanUtils.copyProperties(busEntity,bus);

        return bus;
    }


    @Override
    public Bus AddBus(Bus bus) {

        BusEntity busEntity = new BusEntity();
        BeanUtils.copyProperties(bus,busEntity);
        busRepository.save(busEntity);

        return bus;
    }


    @Override
    public Bus EditBus(Integer id, Bus bus) {

        BusEntity busEntity = busRepository.findById(id).get();

        busEntity.setStart_point(bus.getStart_point());
        busEntity.setEnd_point(bus.getEnd_point());
        busEntity.setBus_type(bus.getBus_type());
        busEntity.setStatus(bus.getStatus());
        busEntity.setNo_of_seats(bus.getNo_of_seats());
        busEntity.setRate(bus.getRate());

        busRepository.save(busEntity);

        return bus;
    }


    @Override
    public Boolean BusDeleted(Integer id) {
        try {
            BusEntity busEntity = busRepository.findById(id).get();
            busRepository.delete(busEntity);
            return true;
        }catch (Exception BusNotFound ){
            return false;
        }
    }
}
