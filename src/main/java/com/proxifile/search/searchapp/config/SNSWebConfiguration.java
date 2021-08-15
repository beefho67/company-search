package com.proxifile.search.searchapp.config;

import static org.springframework.cloud.aws.messaging.endpoint.config.NotificationHandlerMethodArgumentResolverConfigurationUtils.getNotificationHandlerMethodArgumentResolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.context.annotation.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass("org.springframework.web.servlet.config.annotation.WebMvcConfigurer")
@Deprecated
public class SNSWebConfiguration {

	@Value("${aws.access_key_id}")
    private String accessKeyId;
    @Value("${aws.secret_access_key}")
    private String secretAccessKey;
    @Value("${aws.s3.region}")
    private String region;
	
	@Bean
	public AmazonSNS createSnsPublisher() {
		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
        
        return AmazonSNSClientBuilder
                .standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
	}
	
	@Bean
	public WebMvcConfigurer snsWebMvcConfigurer(AmazonSNS amazonSns) {
		return new WebMvcConfigurer() {
			@Override
			public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
				argumentResolvers.add(getNotificationHandlerMethodArgumentResolver(amazonSns));
			}
		};
	}

}
