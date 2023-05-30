package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作轨迹表
 * </p>
 *
 * @author xx
 * @since 2023-05-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tt_record")
public class TtRecordEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    /**
     * 处理人工号
     */
    private String handleUserId;

    /**
     * 处理人姓名
     */
    private String handleUserName;

    /**
     * 处理节点
     */
    private String handleNode;

    /**
     * 处理详情
     */
    private String handleNote;

    /**
     * 记录时间
     */
    private Date handleTime;


}
