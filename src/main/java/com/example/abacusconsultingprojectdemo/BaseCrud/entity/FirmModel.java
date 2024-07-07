package com.example.abacusconsultingprojectdemo.BaseCrud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "firm")
public class FirmModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JsonProperty("firm_id")
    @Column(name = "firm_id", nullable = false)
    private Long firmId;
    @Basic
    @JsonProperty("firm_name")
    @Column(name = "firm_name")
    private String firmName;
    @Basic
    @JsonProperty("contact_number")
    @Column(name = "contact_number")
    private String contactNumber;
    @Basic
    @JsonProperty("firm_address")
    @Column(name = "firm_address")
    private String firmAddress;
    @Basic
    @JsonProperty("email_address")
    @Column(name = "email_address")
    private String emailAddress;
    @Basic
    @JsonProperty("service_fee")
    @Column(name = "service_fee")
    private String serviceFee;
    @Basic
    @JsonProperty("is_active")
    @Column(name = "is_active")
    private String isActive;
    @Basic
    @JsonProperty("created_on")
    @Column(name = "created_on")
    private String createdOn;


}
