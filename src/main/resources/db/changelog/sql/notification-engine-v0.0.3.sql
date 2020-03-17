--
-- Rename last_devivery_attempt column to last_delivery_attempt and remove not null constraint in notification_subject,notification_body,notification_body column in `notification_channel`
--

ALTER TABLE `notification_request` CHANGE `notification_subject` `notification_subject` VARCHAR(255) NULL, CHANGE `notification_body` `notification_body` VARCHAR(255) NULL, CHANGE `last_devivery_attempt` `last_delivery_attempt` DATETIME NULL, CHANGE `request_time` `request_time` DATETIME NULL;

