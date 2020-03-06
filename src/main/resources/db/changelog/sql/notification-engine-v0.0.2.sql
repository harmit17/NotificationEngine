--
-- Rename isDisable column to is_disable in `notification_channel`
--

ALTER TABLE `notification_channel` CHANGE IF EXISTS `isDisable` `is_disable` TINYINT(1) NOT NULL DEFAULT '0';

--
-- Rename isDisable column to is_disable in `notification_content_type`
--

ALTER TABLE `notification_content_type` CHANGE IF EXISTS `isDisable` `is_disable` TINYINT(1) NOT NULL DEFAULT '0';