package com.example.abacusconsultingprojectdemo.BaseCrud.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FirmRequest {
    @JsonProperty("firm_id")
    private Long firmId;
    @JsonProperty("firm_name")
    private String firmName;
    @JsonProperty("contact_number")
    private String contactNumber;
    @JsonProperty("email_address")
//    @NotNull(message = "Email is required")
//    @Email(message = "Email should be valid")
    private String emailAddress;
    @JsonProperty("firm_address")
    private String firmAddress;
    @JsonProperty("service_fee")
    private String serviceFee;
    @JsonProperty("is_active")
    private String isActive;
}


