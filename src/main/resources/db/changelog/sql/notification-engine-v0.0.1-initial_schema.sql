--
-- Table structure for table `notification_channel`
--

CREATE TABLE IF NOT EXISTS Notification_Channel(

	channel_id bigint PRIMARY KEY AUTO_INCREMENT,
	channel_name varchar(50) NOT NULL UNIQUE KEY,
	isDisable boolean NOT NULL DEFAULT false
);

--
-- Dumping data for table `notification_channel`
--

INSERT IGNORE INTO Notification_Channel(channel_name) VALUES
('WhatsApp'),('Email'),('SMS');

--
-- Table structure for table `notification_content_type`
--

CREATE TABLE IF NOT EXISTS notification_content_type
( ct_id BIGINT AUTO_INCREMENT PRIMARY KEY,
 ct_name VARCHAR(50) NOT NULL UNIQUE KEY,
 isDisable BOOLEAN NOT NULL DEFAULT false
);

--
-- Dumping data for table `notification_content_type`
--

INSERT IGNORE INTO `notification_content_type` (`ct_name`) VALUES
('text'),('html');

--
-- Table structure for table `notification_template`
--

CREATE TABLE IF NOT EXISTS notification_template(
    template_id bigint PRIMARY KEY AUTO_INCREMENT,
    template_code varchar(50) NOT null UNIQUE KEY,
    name varchar(50) NOT null,
    description varchar(255),
    template_subject varchar(255) NOT null,
    template_body varchar(1000) NOT null,
    max_retry int(1) NOT null,
    effective_form datetime NOT null,
    effective_to datetime NOT null,
    notification_channel_id bigint NOT null ,
    FOREIGN KEY(notification_channel_id) REFERENCES notification_channel(channel_id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    notification_content_type_id bigint NOT null,
    FOREIGN KEY(notification_content_type_id)REFERENCES notification_content_type(ct_id) ON DELETE RESTRICT ON UPDATE RESTRICT
    );
	
--
-- Table structure for table `notification_request`
--

CREATE TABLE IF NOT EXISTS notification_request(
	request_id BIGINT PRIMARY KEY auto_increment,
	notification_data varchar(1000) NOT null,
	receipient_details varchar(1000) NOT null,
	retry_count integer default 0 NOT null,
	notification_subject varchar(255),
	notification_body varchar(255),
	request_status varchar(50) NOT null,
	last_devivery_attempt datetime,
	request_time datetime,
    notification_template_id BIGINT NOT null,
	KEY notification_template_id (notification_template_id),
	CONSTRAINT FK_notification_template_id FOREIGN KEY (notification_template_id) REFERENCES notification_template(template_id) ON DELETE RESTRICT ON UPDATE RESTRICT  
	);