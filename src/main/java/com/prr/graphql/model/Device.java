package com.prr.graphql.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author mchidambaranatha
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    @Id @GeneratedValue
    @GraphQLQuery(name = "id")
    private Long id;
    @GraphQLQuery(name = "manufacturer")
    private String manufacturer;
    @GraphQLQuery(name = "name")
    private String name;
}
