package com.jmgr.batch_sheduler_api.config;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.parameters.RunIdIncrementer;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleJob {

    @Bean
    public Job helloWorldJob(JobRepository jobRepository, Step helloWorldStep) {
        return new JobBuilder("helloWorldJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(helloWorldStep)
                .build();
    }

    @Bean
    public Step helloWorldStep(JobRepository jobRepository, 
                               Tasklet helloWorldTasklet) {
        return new StepBuilder("helloWorldStep", jobRepository)
                .tasklet(helloWorldTasklet)
                .build();
    }

    @Bean
    public Tasklet helloWorldTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("¡Hola Mundo! Este es mi primer Job de Spring Batch");
            return RepeatStatus.FINISHED;
        };
    }


}
