package com.finablr.platform.notification.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finablr.platform.notification.model.NotificationRequest;

@Repository
public interface notificationenginerepo extends JpaRepository<NotificationRequest, Long>{ 

	
}
 