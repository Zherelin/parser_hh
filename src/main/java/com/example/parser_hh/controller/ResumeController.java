package com.example.parser_hh.controller;

import com.example.parser_hh.model.Resume;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/resume")
public class ResumeController {

    public List<Resume> ParseResume()
    {
        return new ArrayList<Resume>();
    }
}
