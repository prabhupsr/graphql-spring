package com.pr.graphqljava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author mchidambaranatha
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue
    private Long id;
    private String manufacturer;
    private String name;
    @Transient
    private List<String> parts;
}
