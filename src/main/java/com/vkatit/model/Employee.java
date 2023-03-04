package com.vkatit.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {

    @JsonProperty("employeeId")
    private Long employeeId;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("hireDate")
    private String hireDate;
    @JsonProperty("jobId")
    private String jobId;
    @JsonProperty("salary")
    private Float salary;
    @JsonProperty("commissionPCT")
    private Float commissionPCT;
    @JsonProperty("managerId")
    private Long managerId;
    @JsonProperty("departmentId")
    private Long departmentId;


}
