package com.finablr.platform.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finablr.platform.notification.domain.NotificationRequest;

@Repository
public interface NotificationRequestRepository extends JpaRepository<NotificationRequest, Long>{

	//NotificationRequest findOne(Long id);

	
}
 