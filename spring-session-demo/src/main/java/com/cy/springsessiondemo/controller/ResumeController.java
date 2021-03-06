package com.cy.springsessiondemo.controller;

import com.cy.springsessiondemo.jpa.pojo.Resume;
import com.cy.springsessiondemo.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/qryAll")
    @ResponseBody
    public List<Resume> qryAll() {
        return resumeService.qryAll();
    }

    @RequestMapping("/qryById/{id}")
    @ResponseBody
    public Resume qryById(@PathVariable(value = "id") Long id) {
        return  resumeService.qryById(id);
    }

    @RequestMapping("/insertOne")
    @ResponseBody
    public Resume insertOne(Resume resume) {
        return resumeService.insertOne(resume);
    }

    @RequestMapping("/updateOne/{id}")
    @ResponseBody
    public Resume updateOne(@PathVariable(value = "id") Long id, Resume resume) {
        resume.setId(id);
        return resumeService.updateOne(resume);
    }

    @RequestMapping("/deleteOne/{id}")
    @ResponseBody
    public void deleteOne(@PathVariable(value = "id") Long id) {
        resumeService.deleteOne(id);
    }

}
