package com.wujun.domain;

import java.util.Date;

public class PopWindow {
    /**
     * 主键
     */
    private Long id;

    /**
     * 弹窗名称
     */
    private String popWindowName;

    /**
     * 品牌code
     */
    private String brandCode;

    /**
     * 渠道ID
     */
    private Integer channelId;

    /**
     * 终端ID
     */
    private Integer terminalId;

    /**
     * 1 已启用, 2 已关闭
     */
    private Integer status;

    /**
     * 展示周期1小时、4小时、8小时、16小时、24小时
     */
    private Integer period;

    /**
     * 弹窗简介
     */
    private String description;

    /**
     * 1 有效 ,0 无效
     */
    private Integer vaild;

    /**
     * 创建者
     */
    private Long createdBy;

    /**
     * 创建者姓名
     */
    private String createdName;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新者
     */
    private Long updatedBy;

    /**
     * 更新者姓名
     */
    private String updatedName;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 数据版本
     */
    private Integer version;

    /**
     * 获取 [POPWINDOW] 的属性 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置[POPWINDOW]的属性主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 [POPWINDOW] 的属性 弹窗名称
     */
    public String getPopWindowName() {
        return popWindowName;
    }

    /**
     * 设置[POPWINDOW]的属性弹窗名称
     */
    public void setPopWindowName(String popWindowName) {
        this.popWindowName = popWindowName == null ? null : popWindowName.trim();
    }

    /**
     * 获取 [POPWINDOW] 的属性 品牌code
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * 设置[POPWINDOW]的属性品牌code
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode == null ? null : brandCode.trim();
    }

    /**
     * 获取 [POPWINDOW] 的属性 渠道ID
     */
    public Integer getChannelId() {
        return channelId;
    }

    /**
     * 设置[POPWINDOW]的属性渠道ID
     */
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取 [POPWINDOW] 的属性 终端ID
     */
    public Integer getTerminalId() {
        return terminalId;
    }

    /**
     * 设置[POPWINDOW]的属性终端ID
     */
    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * 获取 [POPWINDOW] 的属性 1 已启用, 2 已关闭
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置[POPWINDOW]的属性1 已启用, 2 已关闭
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取 [POPWINDOW] 的属性 展示周期1小时、4小时、8小时、16小时、24小时
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 设置[POPWINDOW]的属性展示周期1小时、4小时、8小时、16小时、24小时
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 获取 [POPWINDOW] 的属性 弹窗简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置[POPWINDOW]的属性弹窗简介
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取 [POPWINDOW] 的属性 1 有效 ,0 无效
     */
    public Integer getVaild() {
        return vaild;
    }

    /**
     * 设置[POPWINDOW]的属性1 有效 ,0 无效
     */
    public void setVaild(Integer vaild) {
        this.vaild = vaild;
    }

    /**
     * 获取 [POPWINDOW] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[POPWINDOW]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [POPWINDOW] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[POPWINDOW]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [POPWINDOW] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[POPWINDOW]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [POPWINDOW] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[POPWINDOW]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [POPWINDOW] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[POPWINDOW]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [POPWINDOW] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[POPWINDOW]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [POPWINDOW] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[POPWINDOW]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}