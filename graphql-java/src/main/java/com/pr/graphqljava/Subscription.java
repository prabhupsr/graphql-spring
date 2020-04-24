package com.pr.graphqljava;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.pr.graphqljava.model.Device;
import com.pr.graphqljava.service.DeviceService;
import lombok.Data;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mchidambaranatha
 */
@Component
@Data
public class Subscription implements GraphQLSubscriptionResolver {
    private DeviceService deviceService;

    public Subscription(DeviceService deviceService) {
        this.deviceService = deviceService;
    }


    public Publisher<Device> devices(int count) {
        final AtomicInteger atomicInteger= new AtomicInteger(0);
        return Flux.create(fluxSink -> {
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    int i1 = atomicInteger.addAndGet(1);
                    int i = new Random().nextInt();
                    fluxSink.next(new Device(Long.valueOf(i), "abc-" + i, "nme-" + i, List.of()));
                    if(i1==count){
                        fluxSink.complete();
                    }
                }
            }, 5L, 500L);
        });

        //return Flux.fromIterable(deviceService.getAllDevices());
    }
}
