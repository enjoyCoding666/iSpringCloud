### sql脚本
# 记录表 tt_record

create table tt_record
(
    id               int                                    not null comment '主键'
        primary key,
    handle_user_id   varchar(20)  default ''                not null comment '处理人id',
    handle_user_name varchar(128) default ''                null comment '处理人姓名',
    handle_node      varchar(50)  default ''                null comment '处理节点',
    handle_note      varchar(256) default ''                null comment '处理详情',
    handle_time      datetime     default CURRENT_TIMESTAMP not null comment '记录时间'
)
    comment '记录表';

create index idx_handle_user_id
    on tt_record (handle_user_id);


