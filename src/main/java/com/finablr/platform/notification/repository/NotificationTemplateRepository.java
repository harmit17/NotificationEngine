package com.finablr.platform.notification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.finablr.platform.notification.domain.NotificationTemplate;

@Repository
public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate, Long> {
	
	Optional<NotificationTemplate> findByTemplateCode(String templateCode);

}
