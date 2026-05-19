package com.jmgr.batch_sheduler_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class JobSchedulerService {

    @Autowired
    private RunJobService runJobService;

    @Scheduled(cron = "0 0/1 * 1/1 * ?")
    public void jobStarter() throws Exception{
        System.out.println(runJobService.runJob());
        
    }

}
