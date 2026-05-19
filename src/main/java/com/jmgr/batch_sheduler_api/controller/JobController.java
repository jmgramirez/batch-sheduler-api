package com.jmgr.batch_sheduler_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmgr.batch_sheduler_api.service.RunJobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private RunJobService runJobService;

    @GetMapping("/start")
    public String startJob() throws Exception {
        return runJobService.runJob();
    }
}