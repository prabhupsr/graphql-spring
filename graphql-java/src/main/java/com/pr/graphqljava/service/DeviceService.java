package com.pr.graphqljava.service;


import com.pr.graphqljava.model.Device;
import com.pr.graphqljava.repo.DeviceRepo;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Optional;

/**
 * @author mchidambaranatha
 */
@Service
public class DeviceService {
    private final DeviceRepo deviceRepo;


    public DeviceService(DeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    public Iterable<Device> getAllDevices() {
        return deviceRepo.findAll();
    }

    public Device addDevice(Device device) {
        return deviceRepo.save(device);
    }

    public Optional<Device> findDevice(Long id){
        return deviceRepo.findById(id);
    }

    public Device deviceDevice(Long deviceId) {
        Optional<Device> byId = deviceRepo.findById(deviceId);
        deviceRepo.deleteById(deviceId);
        return byId.orElse(null);
    }

    public Publisher<Device> createRandomDevice(Long num) {

        System.out.printf("abc");
        return Flux.create(deviceFluxSink -> deviceFluxSink.complete(), FluxSink.OverflowStrategy.LATEST);

    }

}
