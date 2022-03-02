package com.alanchacko.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Region;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
    public static final String AWS_ACCESS_KEY = System.getenv("AWS_ACCESS_KEY");
    public static final String AWS_SECRET_KEY = System.getenv("AWS_SECRET_KEY");

    @Bean
    public AmazonS3 s3() {
        Regions region = Regions.US_EAST_1;
        AWSCredentials awsCredentials = new BasicAWSCredentials(AWS_ACCESS_KEY,AWS_SECRET_KEY);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
