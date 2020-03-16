--
-- Rename isDisable column to is_disable in `notification_channel`
--

<<<<<<< HEAD
ALTER TABLE `notification_channel` CHANGE  `isDisable` `is_disable` TINYINT(1) NOT NULL DEFAULT '0';
=======
ALTER TABLE `notification_channel` CHANGE `isDisable` `is_disable` TINYINT(1) NOT NULL DEFAULT '0';
>>>>>>> development

--
-- Rename isDisable column to is_disable in `notification_content_type`
--

<<<<<<< HEAD
ALTER TABLE `notification_content_type` CHANGE  `isDisable` `is_disable` TINYINT(1) NOT NULL DEFAULT '0';
=======
ALTER TABLE `notification_content_type` CHANGE `isDisable` `is_disable` TINYINT(1) NOT NULL DEFAULT '0';
>>>>>>> development
