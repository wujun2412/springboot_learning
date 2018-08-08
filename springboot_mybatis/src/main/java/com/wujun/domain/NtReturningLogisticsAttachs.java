package com.wujun.domain;

import java.util.Date;

public class NtReturningLogisticsAttachs {
    /**
     * 文件ID号
     */
    private Long ATTACHMENT_ID;

    /**
     * 指使用系统的吉利集团所属的公司，即车厂端公司
     */
    private Integer COMPANY_ID;

    /**
     * 装箱ID
     */
    private Long BOX_ID;

    /**
     * 装箱号
     */
    private String CASE_NO;

    /**
     * 文件名称
     */
    private String ATTACHMENT_NAME;

    /**
     * 附件描述
     */
    private String ATTACHMENT_DESC;

    /**
     * 创建者
     */
    private Integer CREATED_BY;

    /**
     * 系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义
     */
    private Date CREATED_TIME;

    /**
     * 更新者
     */
    private Integer UPDATED_BY;

    /**
     * 系统保留字段，记录数据最后时间，用于审计，无业务含义
     */
    private Date UPDATED_TIME;

    /**
     * 系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
     */
    private Integer VERSION;

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 文件ID号
     */
    public Long getATTACHMENT_ID() {
        return ATTACHMENT_ID;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性文件ID号
     */
    public void setATTACHMENT_ID(Long ATTACHMENT_ID) {
        this.ATTACHMENT_ID = ATTACHMENT_ID;
    }

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 指使用系统的吉利集团所属的公司，即车厂端公司
     */
    public Integer getCOMPANY_ID() {
        return COMPANY_ID;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性指使用系统的吉利集团所属的公司，即车厂端公司
     */
    public void setCOMPANY_ID(Integer COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 装箱ID
     */
    public Long getBOX_ID() {
        return BOX_ID;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性装箱ID
     */
    public void setBOX_ID(Long BOX_ID) {
        this.BOX_ID = BOX_ID;
    }

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 装箱号
     */
    public String getCASE_NO() {
        return CASE_NO;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性装箱号
     */
    public void setCASE_NO(String CASE_NO) {
        this.CASE_NO = CASE_NO == null ? null : CASE_NO.trim();
    }

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 文件名称
     */
    public String getATTACHMENT_NAME() {
        return ATTACHMENT_NAME;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性文件名称
     */
    public void setATTACHMENT_NAME(String ATTACHMENT_NAME) {
        this.ATTACHMENT_NAME = ATTACHMENT_NAME == null ? null : ATTACHMENT_NAME.trim();
    }

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 附件描述
     */
    public String getATTACHMENT_DESC() {
        return ATTACHMENT_DESC;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性附件描述
     */
    public void setATTACHMENT_DESC(String ATTACHMENT_DESC) {
        this.ATTACHMENT_DESC = ATTACHMENT_DESC == null ? null : ATTACHMENT_DESC.trim();
    }

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 创建者
     */
    public Integer getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性创建者
     */
    public void setCREATED_BY(Integer CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义
     */
    public Date getCREATED_TIME() {
        return CREATED_TIME;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义
     */
    public void setCREATED_TIME(Date CREATED_TIME) {
        this.CREATED_TIME = CREATED_TIME;
    }

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 更新者
     */
    public Integer getUPDATED_BY() {
        return UPDATED_BY;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性更新者
     */
    public void setUPDATED_BY(Integer UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 系统保留字段，记录数据最后时间，用于审计，无业务含义
     */
    public Date getUPDATED_TIME() {
        return UPDATED_TIME;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性系统保留字段，记录数据最后时间，用于审计，无业务含义
     */
    public void setUPDATED_TIME(Date UPDATED_TIME) {
        this.UPDATED_TIME = UPDATED_TIME;
    }

    /**
     * 获取 [NT_RETURNING_LOGISTICS_ATTACHS] 的属性 系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
     */
    public Integer getVERSION() {
        return VERSION;
    }

    /**
     * 设置[NT_RETURNING_LOGISTICS_ATTACHS]的属性系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
     */
    public void setVERSION(Integer VERSION) {
        this.VERSION = VERSION;
    }
}