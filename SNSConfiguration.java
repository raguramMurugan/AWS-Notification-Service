package com.hubino.sns.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class SNSConfiguration {

	

	@Bean
	public AmazonSNSClient snsclient()
	{
		BasicAWSCredentials credentials =new BasicAWSCredentials("AKIAQKD3UYI4R7IKLXH5", "ZYzsFUHomBTXFmLHHhvnS4nAeMqO4CSfrCjwUmp4");
		return (AmazonSNSClient) AmazonSNSClientBuilder
				.standard()
				.withRegion(Regions.AP_NORTHEAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.build();
				
	}
}
