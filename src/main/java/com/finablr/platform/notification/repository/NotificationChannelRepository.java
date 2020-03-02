package com.finablr.platform.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finablr.platform.notification.domain.NotificationChannel;

@Repository
public interface NotificationChannelRepository extends JpaRepository<NotificationChannel, Long>{

}
