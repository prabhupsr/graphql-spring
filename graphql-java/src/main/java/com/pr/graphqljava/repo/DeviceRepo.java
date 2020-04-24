package com.pr.graphqljava.repo;

import com.pr.graphqljava.model.Device;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mchidambaranatha
 */
public interface DeviceRepo extends CrudRepository<Device, Long> {
}
