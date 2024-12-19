// package com.example.nmc.Pasien;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// import com.twilio.Twilio;
// import com.twilio.rest.api.v2010.account.Message;

// @Service
// public class TwilioService {

//     @Value("ACb44425032e99832c1eb890dc89489eac")
//     private String accountSid;

//     @Value("560647c25824bbce4ae96e8d1c890436")
//     private String authToken;

//     @Value("+14155238886")
//     private String fromPhoneNumber;

//     public TwilioService(@Value("ACb44425032e99832c1eb890dc89489eac") String accountSid, 
//                          @Value("560647c25824bbce4ae96e8d1c890436") String authToken, 
//                          @Value("+14155238886") String fromPhoneNumber) {
//         this.accountSid = accountSid;
//         this.authToken = authToken;
//         this.fromPhoneNumber = fromPhoneNumber;

//         // Inisialisasi Twilio di dalam konstruktor
//         Twilio.init(accountSid, authToken);
//     }

//     public void sendOtp(String toPhoneNumber, String otp) {
//         try {
//             String messageContent = "Kode OTP Anda adalah: " + otp;

//             Message message = Message.creator(
//                     new com.twilio.type.PhoneNumber("whatsapp:" + toPhoneNumber), // Nomor tujuan
//                     new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), // Nomor pengirim
//                     messageContent                                                 // Isi pesan
//             ).create();

//             System.out.println("Pesan berhasil dikirim: " + message.getSid());
//         } catch (Exception e) {
//             System.err.println("Gagal mengirim OTP: " + e.getMessage());
//             throw new RuntimeException("Gagal mengirim OTP");
//         }
//     }
// }
