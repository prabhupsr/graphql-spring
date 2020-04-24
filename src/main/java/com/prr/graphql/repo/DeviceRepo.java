package com.prr.graphql.repo;

import com.prr.graphql.model.Device;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mchidambaranatha
 */
public interface DeviceRepo extends CrudRepository<Device,Long> {
}
