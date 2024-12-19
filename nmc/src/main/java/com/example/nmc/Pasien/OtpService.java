// package com.example.nmc.Pasien;

// import com.example.nmc.TwillioConfig;
// import com.twilio.Twilio;
// import com.twilio.rest.api.v2010.account.Message;
// import com.twilio.type.PhoneNumber;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class OtpService {

//     private final TwillioConfig twilioConfig;

//     @Autowired
//     public OtpService(TwillioConfig twilioConfig) {
//         this.twilioConfig = twilioConfig;
//         Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
//     }

//     public String generateOtp() {
//         // Generate OTP 4-6 digit random
//         return String.valueOf((int) (Math.random() * 9000) + 1000);
//     }

//     public void sendOtpViaWhatsApp(String phoneNumber, String otp) {
//         String formattedNumber = "whatsapp:" + phoneNumber; // Format nomor WhatsApp
//         String messageContent = "Kode OTP Anda adalah: " + otp;

//         Message message = Message.creator(
//                 new PhoneNumber(formattedNumber),           // Nomor tujuan
//                 new PhoneNumber(twilioConfig.getWhatsappNumber()), // Nomor WhatsApp Twilio Anda
//                 messageContent                             // Isi pesan
//         ).create();

//         System.out.println("Pesan WhatsApp terkirim. SID: " + message.getSid());
//     }
// }
