-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `base_author`;
CREATE TABLE `base_author`
(
  `id`          varchar(36) NOT NULL COMMENT 'id',
  `name`        varchar(50) NOT NULL COMMENT '姓名',
  `age`         int(11) NOT NULL COMMENT '年龄',
  `create_time` datetime    NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
