package com.pr.graphqljava;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pr.graphqljava.model.Device;
import com.pr.graphqljava.service.DeviceService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author mchidambaranatha
 */
@Data
@Component
public class Query implements GraphQLQueryResolver {

    private DeviceService deviceService;

    public Query(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public Iterable<Device> devices() {
        return deviceService.getAllDevices();
    }

    public Optional<Device> device(Long id) {
        Optional<Device> device1 = deviceService.findDevice(id);
        device1.ifPresent(device -> device.setParts(List.of("part 1", "part2", "part 3")));
        return
        device1;
    }
}
