package com.example.abacusconsultingprojectdemo.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ResponseCodes {

    SUCCESS("00"),

    FIRM_ALREADY_REGISTER("Firm Already Registered By this Email "),
    FIRM_CREATED_SUCCESSFULLY("Firm created successfully"),
    FIRM_UPDATED_SUCCESSFULLY("Firm updated successfully"),
    EMAIL_CAN_NOT_BE_NULL("Email can not be null"),
    NO_FIRMS_FOUND("No Firms Found"),

    FIRM_DONT_EXIST("Firm don't exist"),

    FAILURE("01"),
    BAD_REQUEST("02"),
    INTERNAL_SERVER_ERROR("500");
    private static final Map<String,ResponseCodes> lookup = new HashMap<String,ResponseCodes>();

    /**
     * The static block to populate the Map uses a specialized implementation of Set, java.util.EnumSet,
     * that "probably" (according to the javadocs) has better performance than java.util.HashSet.
     * Java 5.0 also provides java.util.EnumMap, a specialized implementation of
     * Map for enumerations that is more compact than java.util.HashMap.
     */
    static {
        for(ResponseCodes responseCodes : EnumSet.allOf(ResponseCodes.class))
            lookup.put(responseCodes.getValue(), responseCodes);
    }

    private ResponseCodes(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    /**
     * The static get(int) method here provides the reverse lookup by simply
     * getting the value from the Map,
     * @param code
     * @return RDVMB_ResponseCodeEnum
     */
    public static ResponseCodes lookup(String code) {
        return lookup.get(code);
    }

}

