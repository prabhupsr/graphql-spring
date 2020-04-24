package com.prr.graphql.service;

import com.prr.graphql.model.Device;
import com.prr.graphql.repo.DeviceRepo;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLSubscription;

import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import io.leangen.graphql.spqr.spring.util.ConcurrentMultiMap;
import org.reactivestreams.Publisher;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Optional;

/**
 * @author mchidambaranatha
 */
@Service
@GraphQLApi
public class DeviceService {
    private final DeviceRepo deviceRepo;


    public DeviceService(DeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @GraphQLQuery(name = "devices")
    public Iterable<Device> getAllDevices() {
        return deviceRepo.findAll();
    }

    @GraphQLMutation(name = "addDevice")
    public Device addDevice(@GraphQLArgument(name = "deviceDetails") Device device) {
        return deviceRepo.save(device);
    }

    @GraphQLMutation(name = "deviceDevice")
    public Device deviceDevice(@GraphQLArgument(name = "id") Long deviceId) {
        Optional<Device> byId = deviceRepo.findById(deviceId);
        deviceRepo.deleteById(deviceId);
        return byId.orElse(null);
    }

    @GraphQLSubscription(name = "createRandomDevicee")
    public Publisher<Device> createRandomDevice(@GraphQLArgument(name = "num") Long num) {

        System.out.printf("abc");
        return Flux.create(deviceFluxSink -> deviceFluxSink.complete(), FluxSink.OverflowStrategy.LATEST);

    }

}
