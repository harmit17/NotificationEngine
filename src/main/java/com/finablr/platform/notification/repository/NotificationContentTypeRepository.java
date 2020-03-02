package com.finablr.platform.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finablr.platform.notification.domain.NotificationContentType;

@Repository
public interface NotificationContentTypeRepository extends JpaRepository<NotificationContentType, Long> {
}
