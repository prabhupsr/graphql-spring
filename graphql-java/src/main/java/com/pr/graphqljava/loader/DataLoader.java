package com.pr.graphqljava.loader;


import com.pr.graphqljava.model.Device;
import com.pr.graphqljava.repo.DeviceRepo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author mchidambaranatha
 */
@Component
public class DataLoader {

    private DeviceRepo deviceRepo;

    public DataLoader(DeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @PostConstruct
    public void load(){
        IntStream.range(0,100)
                .mapToObj(value -> new Device(null,"M-"+value,"Name-"+value, List.of("RAM","DISPLAY","Charger")))
                .forEach(deviceRepo::save);
    }
}
