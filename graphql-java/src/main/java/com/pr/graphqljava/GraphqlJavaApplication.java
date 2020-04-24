package com.pr.graphqljava;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.SchemaParser;
import com.pr.graphqljava.model.Device;
import com.pr.graphqljava.service.DeviceService;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlJavaApplication.class, args);
    }
/*
    @Autowired
    private DeviceService deviceService;


    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(SimpleGraphQLHttpServlet.newBuilder(graphQLSchema()).build(), "/graphql");
    }

    private GraphQLSchema graphQLSchema() {
        return SchemaParser.newParser()
                .file("graphql/schema.graphqls")
                .resolvers(new Query(deviceService)).build()
                .makeExecutableSchema();
    }*/
}
