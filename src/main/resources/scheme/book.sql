-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(
  `id`          varchar(36)   NOT NULL COMMENT 'id',
  `name`        varchar(50)   NOT NULL COMMENT '名称',
  `price`       decimal(9, 2) NOT NULL COMMENT '价格',
  `author_id`   varchar(36)   NOT NULL COMMENT '作者id',
  `create_time` datetime      NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
