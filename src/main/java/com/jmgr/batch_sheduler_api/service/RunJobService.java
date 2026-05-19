package com.jmgr.batch_sheduler_api.service;

import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.batch.core.job.Job;

@Service
public class RunJobService {

    @Autowired
    JobLauncher jobLauncher;

    @Qualifier("helloWorldJob")
    @Autowired
    Job helloWorldJob;

    public String runJob() throws Exception {
        var jobParameters = new JobParametersBuilder()
                .addLong("currentTime", System.currentTimeMillis())
                .toJobParameters();
        
        jobLauncher.run(helloWorldJob, jobParameters);
        
        return "Job Started";
    }

}
