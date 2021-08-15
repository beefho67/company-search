package com.proxifile.search.searchapp.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationSubject;
import org.springframework.cloud.aws.messaging.endpoint.NotificationStatus;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationMessageMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationUnsubscribeConfirmationMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proxifile.search.searchapp.service.CreditorService;


@RestController
@RequestMapping("/aws/newcsv")
public class AWSRestController {

	@Autowired
	private CreditorService creditorService;
	
//	@GetMapping("/newcsv")
//	public String newCSV(){
//		
//		creditorService.massInsert();
//		
//		return "Success";
//	}
	
	@NotificationSubscriptionMapping
	public void handleSubscriptionMessage(NotificationStatus status) throws IOException {
		//We subscribe to start receive the message
		status.confirmSubscription();
	}

	@NotificationMessageMapping
	public void handleNotificationMessage(@NotificationSubject String subject, @NotificationMessage String message) {
		
		creditorService.massInsert();
		
	}

	@NotificationUnsubscribeConfirmationMapping
	public void handleUnsubscribeMessage(NotificationStatus status) {
		//e.g. the client has been unsubscribed and we want to "re-subscribe"
		status.confirmSubscription();
	}
}
