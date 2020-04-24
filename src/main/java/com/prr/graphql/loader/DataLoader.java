package com.prr.graphql.loader;

import com.prr.graphql.model.Device;
import com.prr.graphql.repo.DeviceRepo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
                .mapToObj(value -> new Device(null,"Manufa-"+value,"Name-"+value))
                .forEach(deviceRepo::save);
    }
}
