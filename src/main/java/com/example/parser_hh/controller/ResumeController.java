package com.example.parser_hh.controller;

import com.example.parser_hh.model.Resume;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/resume")
public class ResumeController {

    @GetMapping("/gettest")
    public List<Resume> ParseResume()
    {
        // -- test --
        Resume testResume = new Resume();
        testResume.setTitle("testTitle");
        testResume.setAge("testAge");

        List<Resume> testListResume = new ArrayList<>();
        testListResume.add(testResume);

        return testListResume;
        // ---*----
    }
}
