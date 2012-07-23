-- Dumping structure for table nzonly_tb.auth_info
DROP TABLE IF EXISTS `auth_info`;
CREATE TABLE IF NOT EXISTS `auth_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `taobao_user_id` varchar(64) DEFAULT NULL COMMENT '淘宝用户 id',
  `taobao_user_nick` varchar(64) DEFAULT NULL COMMENT '淘宝用户昵称',
  `access_token` varchar(64) DEFAULT NULL COMMENT 'Access token',
  `token_type` varchar(64) DEFAULT NULL COMMENT 'Access token的类型目前只支持bearer',
  `expires_in` bigint(20) unsigned DEFAULT NULL COMMENT 'Access token过期时间 单位秒',
  `refresh_token` varchar(64) DEFAULT NULL COMMENT 'Refresh token',
  `re_expires_in` bigint(20) unsigned DEFAULT NULL COMMENT 'Refresh token过期时间 单位秒',
  `r1_expires_in` bigint(20) unsigned DEFAULT NULL COMMENT 'r1级别API或字段的访问过期时间',
  `r2_expires_in` bigint(20) unsigned DEFAULT NULL COMMENT 'r2级别API或字段的访问过期时间',
  `w1_expires_in` bigint(20) unsigned DEFAULT NULL COMMENT 'w1级别API或字段的访问过期时间',
  `w2_expires_in` bigint(20) unsigned DEFAULT NULL COMMENT 'w2级别API或字段的访问过期时间',
  `create_time` datetime DEFAULT NULL COMMENT 'w2级别API或字段的访问过期时间',
  `last_update_time` datetime DEFAULT NULL COMMENT 'w2级别API或字段的访问过期时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `taobao_user_id` (`taobao_user_id`),
  KEY `access_token` (`access_token`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='授权信息表';

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_blob_triggers
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE IF NOT EXISTS `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_calendars
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE IF NOT EXISTS `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_cron_triggers
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE IF NOT EXISTS `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_fired_triggers
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE IF NOT EXISTS `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_job_details
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE IF NOT EXISTS `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_locks
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE IF NOT EXISTS `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_paused_trigger_grps
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE IF NOT EXISTS `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_scheduler_state
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE IF NOT EXISTS `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_simple_triggers
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE IF NOT EXISTS `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_simprop_triggers
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE IF NOT EXISTS `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.qrtz_triggers
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE IF NOT EXISTS `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.taobao_task
DROP TABLE IF EXISTS `taobao_task`;
CREATE TABLE IF NOT EXISTS `taobao_task` (
  `task_id` bigint(20) NOT NULL COMMENT '异步任务id。创建异步任务时返回的任务id号',
  `created` datetime DEFAULT NULL COMMENT '任务创建时间',
  `params` varchar(1000) DEFAULT NULL COMMENT '任务提交时的参数',
  `body` varchar(1000) DEFAULT NULL COMMENT '响应 body',
  `method` varchar(80) DEFAULT NULL COMMENT '此任务是由哪个api产生的',
  `status` varchar(50) DEFAULT NULL COMMENT '异步任务处理状态。new（还未开始处理），doing（处理中），done（处理结束）。',
  `download_url` varchar(500) DEFAULT NULL COMMENT '大任务结果下载地址。当创建的认任务是大数据量的任务时，获取结果会返回此字段，同时subtasks列表会为空。',
  `check_code` varchar(64) DEFAULT NULL COMMENT '下载文件的MD5校验码，通过此校验码可以检查下载的文件是否是完整的',
  `last_check_time` datetime DEFAULT NULL COMMENT '任务最后一次检查时间',
  PRIMARY KEY (`task_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='淘宝api异步调用, 任务信息';

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.taobao_trade
DROP TABLE IF EXISTS `taobao_trade`;
CREATE TABLE IF NOT EXISTS `taobao_trade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tid` bigint(20) DEFAULT NULL COMMENT '淘宝订单信息',
  `auth_id` bigint(20) DEFAULT NULL COMMENT '授权信息id',
  `out_sid` varchar(64) DEFAULT NULL COMMENT '运单号',
  `company_name` varchar(64) DEFAULT NULL COMMENT '物流公司',
  `out_status` varchar(64) DEFAULT NULL COMMENT '物流信息状态, 订单的物流状态 * 等候发送给物流公司 *已提交给物流公司,等待物流公司接单 *已经确认消息接收，等待物流公司接单 *物流公司已接单 *物流公司不接单 *物流公司揽收失败 *物流公司揽收成功 *签收失败 *对方已签收 *对方拒绝签收',
  `buyer_nick` varchar(100) DEFAULT NULL COMMENT '买家昵称',
  `buyer_alipay_no` varchar(100) DEFAULT NULL COMMENT '买家支付宝账号',
  `payment` double DEFAULT NULL COMMENT '支付金额',
  `orders` mediumtext COMMENT '订单详细, JSON 格式',
  `delivery_track` varchar(15000) DEFAULT NULL COMMENT '物流信息跟踪',
  `last_update_time` datetime DEFAULT NULL COMMENT '业务处理时间',
  `note` varchar(50) DEFAULT NULL COMMENT '备注(本地, 不是淘宝提供的)',
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='订单信息表';

-- Data exporting was unselected.


-- Dumping structure for table nzonly_tb.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` varchar(50) DEFAULT NULL COMMENT '登录名',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `from_channel` varchar(60) DEFAULT NULL COMMENT '来源(渠道) 如: 淘宝,新浪微博等',
  `auth_id` bigint(20) DEFAULT NULL COMMENT '授权信息',
  `auth_user_id` varchar(50) DEFAULT NULL COMMENT '授权用户id, 如淘宝 id',
  `pwd` varchar(64) DEFAULT NULL COMMENT '登录密码',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐值',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`),
  KEY `nickname` (`nickname`),
  KEY `auth_id` (`auth_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统用户表';
