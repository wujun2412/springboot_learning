package com.wujun.domain;

import java.util.Date;

public class PopWindowPosition {
    /**
     * 主键
     */
    private Long id;

    /**
     * 弹窗ID
     */
    private Long popwindowId;

    /**
     * 分发中心点位ID
     */
    private Integer positionId;

    /**
     * 排序号
     */
    private Integer positionSeq;

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
     * 获取 [POPWINDOW_POSITION] 的属性 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 弹窗ID
     */
    public Long getPopwindowId() {
        return popwindowId;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性弹窗ID
     */
    public void setPopwindowId(Long popwindowId) {
        this.popwindowId = popwindowId;
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 分发中心点位ID
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性分发中心点位ID
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 排序号
     */
    public Integer getPositionSeq() {
        return positionSeq;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性排序号
     */
    public void setPositionSeq(Integer positionSeq) {
        this.positionSeq = positionSeq;
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 1 有效 ,0 无效
     */
    public Integer getVaild() {
        return vaild;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性1 有效 ,0 无效
     */
    public void setVaild(Integer vaild) {
        this.vaild = vaild;
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 创建者
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性创建者
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 创建者姓名
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性创建者姓名
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 更新者
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性更新者
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 更新者姓名
     */
    public String getUpdatedName() {
        return updatedName;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性更新者姓名
     */
    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取 [POPWINDOW_POSITION] 的属性 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置[POPWINDOW_POSITION]的属性数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}