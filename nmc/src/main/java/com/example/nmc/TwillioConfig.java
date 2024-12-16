package com.example.nmc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwillioConfig {

    @Value("ACb44425032e99832c1eb890dc89489eac")
    private String accountSid;

    @Value("560647c25824bbce4ae96e8d1c890436")
    private String authToken;

    @Value("+14155238886")
    private String whatsappNumber;

    public String getAccountSid() {
        return accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }
}
