package com.example.nmc.Testing;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@AllArgsConstructor
@RequestMapping("/testing")
public class TestingController {

    private final TestingService testingService;

    @GetMapping
    public String testing(HttpSession session) {
        System.out.println("testing");
        return "TestingView";
    }

    @PostMapping("upload")
    public String save(
            @RequestParam("name") String name,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            // check if directory exists
            File dir = new File(System.getProperty("user.dir") + "/Uploads");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String destination = System.getProperty("user.dir") + "/Uploads" + File.separator + file.getOriginalFilename();
            file.transferTo(new java.io.File(destination));

            Testing testing = new Testing();
            testing.setFilename(name);
            testing.setPath(destination);

            testingService.save(testing);
        } catch (IOException e) {
            e.printStackTrace();

            System.out.println("Error when save testing: " + e.getMessage());
        }

        return "TestingView";
    }
}
