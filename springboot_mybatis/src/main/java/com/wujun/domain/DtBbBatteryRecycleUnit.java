package com.wujun.domain;

import java.util.Date;

public class DtBbBatteryRecycleUnit {
    /**
     * 企业单位ID
     */
    private Integer UNIT_ID;

    /**
     * 企业单位代码
     */
    private String UNIT_NO;

    /**
     * 企业单位名称
     */
    private String UNIT_NAME;

    /**
     * 退役企业统一社会信用代码
     */
    private String CREDIT_CODE;

    /**
     * 省份，来源：区域定义表
     */
    private Integer PROVINCE;

    /**
     * 城市，来源：区域定义表
     */
    private Integer CITY;

    /**
     * 来源：区域定义表
     */
    private Integer COUNTY;

    /**
     * 详细地址
     */
    private String ADDRESS;

    /**
     * 电话
     */
    private String PHONE_NO;

    /**
     * 企业单位类型：电池供应商、退役企业
     */
    private Integer UNIT_TYPE;

    /**
     * 是否停用
     */
    private Short IS_DISABLE;

    /**
     * 是否下发
     */
    private Short IS_DOWN;

    /**
     * 备注
     */
    private String REMARK;

    /**
     * 创建者
     */
    private Integer CREATED_BY;

    /**
     * 创建时间
     */
    private Date CREATED_TIME;

    /**
     * 更新者
     */
    private Integer UPDATED_BY;

    /**
     * 更新时间
     */
    private Date UPDATED_TIME;

    /**
     * 数据版本
     */
    private Integer VERSION;

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 企业单位ID
     */
    public Integer getUNIT_ID() {
        return UNIT_ID;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性企业单位ID
     */
    public void setUNIT_ID(Integer UNIT_ID) {
        this.UNIT_ID = UNIT_ID;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 企业单位代码
     */
    public String getUNIT_NO() {
        return UNIT_NO;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性企业单位代码
     */
    public void setUNIT_NO(String UNIT_NO) {
        this.UNIT_NO = UNIT_NO == null ? null : UNIT_NO.trim();
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 企业单位名称
     */
    public String getUNIT_NAME() {
        return UNIT_NAME;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性企业单位名称
     */
    public void setUNIT_NAME(String UNIT_NAME) {
        this.UNIT_NAME = UNIT_NAME == null ? null : UNIT_NAME.trim();
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 退役企业统一社会信用代码
     */
    public String getCREDIT_CODE() {
        return CREDIT_CODE;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性退役企业统一社会信用代码
     */
    public void setCREDIT_CODE(String CREDIT_CODE) {
        this.CREDIT_CODE = CREDIT_CODE == null ? null : CREDIT_CODE.trim();
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 省份，来源：区域定义表
     */
    public Integer getPROVINCE() {
        return PROVINCE;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性省份，来源：区域定义表
     */
    public void setPROVINCE(Integer PROVINCE) {
        this.PROVINCE = PROVINCE;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 城市，来源：区域定义表
     */
    public Integer getCITY() {
        return CITY;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性城市，来源：区域定义表
     */
    public void setCITY(Integer CITY) {
        this.CITY = CITY;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 来源：区域定义表
     */
    public Integer getCOUNTY() {
        return COUNTY;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性来源：区域定义表
     */
    public void setCOUNTY(Integer COUNTY) {
        this.COUNTY = COUNTY;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 详细地址
     */
    public String getADDRESS() {
        return ADDRESS;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性详细地址
     */
    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS == null ? null : ADDRESS.trim();
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 电话
     */
    public String getPHONE_NO() {
        return PHONE_NO;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性电话
     */
    public void setPHONE_NO(String PHONE_NO) {
        this.PHONE_NO = PHONE_NO == null ? null : PHONE_NO.trim();
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 企业单位类型：电池供应商、退役企业
     */
    public Integer getUNIT_TYPE() {
        return UNIT_TYPE;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性企业单位类型：电池供应商、退役企业
     */
    public void setUNIT_TYPE(Integer UNIT_TYPE) {
        this.UNIT_TYPE = UNIT_TYPE;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 是否停用
     */
    public Short getIS_DISABLE() {
        return IS_DISABLE;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性是否停用
     */
    public void setIS_DISABLE(Short IS_DISABLE) {
        this.IS_DISABLE = IS_DISABLE;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 是否下发
     */
    public Short getIS_DOWN() {
        return IS_DOWN;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性是否下发
     */
    public void setIS_DOWN(Short IS_DOWN) {
        this.IS_DOWN = IS_DOWN;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 备注
     */
    public String getREMARK() {
        return REMARK;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性备注
     */
    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 创建者
     */
    public Integer getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性创建者
     */
    public void setCREATED_BY(Integer CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 创建时间
     */
    public Date getCREATED_TIME() {
        return CREATED_TIME;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性创建时间
     */
    public void setCREATED_TIME(Date CREATED_TIME) {
        this.CREATED_TIME = CREATED_TIME;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 更新者
     */
    public Integer getUPDATED_BY() {
        return UPDATED_BY;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性更新者
     */
    public void setUPDATED_BY(Integer UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 更新时间
     */
    public Date getUPDATED_TIME() {
        return UPDATED_TIME;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性更新时间
     */
    public void setUPDATED_TIME(Date UPDATED_TIME) {
        this.UPDATED_TIME = UPDATED_TIME;
    }

    /**
     * 获取 [DT_BB_BATTERY_RECYCLE_UNIT] 的属性 数据版本
     */
    public Integer getVERSION() {
        return VERSION;
    }

    /**
     * 设置[DT_BB_BATTERY_RECYCLE_UNIT]的属性数据版本
     */
    public void setVERSION(Integer VERSION) {
        this.VERSION = VERSION;
    }
}