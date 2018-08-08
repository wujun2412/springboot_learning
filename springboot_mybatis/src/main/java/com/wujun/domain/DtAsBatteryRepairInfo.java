package com.wujun.domain;

import java.util.Date;

public class DtAsBatteryRepairInfo {
    /**
     * 电池维修记录ID
     */
    private Long REPAIR_ID;

    /**
     * 公司ID
     */
    private Integer COMPANY_ID;

    /**
     * 委托书编号
     */
    private String SO_NO;

    /**
     * 电池维修类型：更换、维修
     */
    private Integer REPAIR_TYPE;

    /**
     * 更换类型：电池包、电池组、电池模块
     */
    private Integer CHANGE_TYPE;

    /**
     * 旧电池去向类型：客户、网点、供应商
     */
    private Integer OLD_TO_TYPE;

    /**
     * 老电池包编号
     */
    private String OLD_BATTERY_PACK_NO;

    /**
     * 新电池包编号
     */
    private String NEW_BATTERY_PACK_NO;

    /**
     * 旧电池去向单位编号
     */
    private Long UNIT_ID;

    /**
     * 旧电池去向单位名称
     */
    private String UNIT_NAME;

    /**
     * 旧电池去向企业统一社会信用代码
     */
    private String CREDIT_CODE;

    /**
     * 电池维修更换时间
     */
    private Date BUSINESS_DATE;

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
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 电池维修记录ID
     */
    public Long getREPAIR_ID() {
        return REPAIR_ID;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性电池维修记录ID
     */
    public void setREPAIR_ID(Long REPAIR_ID) {
        this.REPAIR_ID = REPAIR_ID;
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 公司ID
     */
    public Integer getCOMPANY_ID() {
        return COMPANY_ID;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性公司ID
     */
    public void setCOMPANY_ID(Integer COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 委托书编号
     */
    public String getSO_NO() {
        return SO_NO;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性委托书编号
     */
    public void setSO_NO(String SO_NO) {
        this.SO_NO = SO_NO == null ? null : SO_NO.trim();
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 电池维修类型：更换、维修
     */
    public Integer getREPAIR_TYPE() {
        return REPAIR_TYPE;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性电池维修类型：更换、维修
     */
    public void setREPAIR_TYPE(Integer REPAIR_TYPE) {
        this.REPAIR_TYPE = REPAIR_TYPE;
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 更换类型：电池包、电池组、电池模块
     */
    public Integer getCHANGE_TYPE() {
        return CHANGE_TYPE;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性更换类型：电池包、电池组、电池模块
     */
    public void setCHANGE_TYPE(Integer CHANGE_TYPE) {
        this.CHANGE_TYPE = CHANGE_TYPE;
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 旧电池去向类型：客户、网点、供应商
     */
    public Integer getOLD_TO_TYPE() {
        return OLD_TO_TYPE;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性旧电池去向类型：客户、网点、供应商
     */
    public void setOLD_TO_TYPE(Integer OLD_TO_TYPE) {
        this.OLD_TO_TYPE = OLD_TO_TYPE;
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 老电池包编号
     */
    public String getOLD_BATTERY_PACK_NO() {
        return OLD_BATTERY_PACK_NO;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性老电池包编号
     */
    public void setOLD_BATTERY_PACK_NO(String OLD_BATTERY_PACK_NO) {
        this.OLD_BATTERY_PACK_NO = OLD_BATTERY_PACK_NO == null ? null : OLD_BATTERY_PACK_NO.trim();
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 新电池包编号
     */
    public String getNEW_BATTERY_PACK_NO() {
        return NEW_BATTERY_PACK_NO;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性新电池包编号
     */
    public void setNEW_BATTERY_PACK_NO(String NEW_BATTERY_PACK_NO) {
        this.NEW_BATTERY_PACK_NO = NEW_BATTERY_PACK_NO == null ? null : NEW_BATTERY_PACK_NO.trim();
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 旧电池去向单位编号
     */
    public Long getUNIT_ID() {
        return UNIT_ID;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性旧电池去向单位编号
     */
    public void setUNIT_ID(Long UNIT_ID) {
        this.UNIT_ID = UNIT_ID;
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 旧电池去向单位名称
     */
    public String getUNIT_NAME() {
        return UNIT_NAME;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性旧电池去向单位名称
     */
    public void setUNIT_NAME(String UNIT_NAME) {
        this.UNIT_NAME = UNIT_NAME == null ? null : UNIT_NAME.trim();
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 旧电池去向企业统一社会信用代码
     */
    public String getCREDIT_CODE() {
        return CREDIT_CODE;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性旧电池去向企业统一社会信用代码
     */
    public void setCREDIT_CODE(String CREDIT_CODE) {
        this.CREDIT_CODE = CREDIT_CODE == null ? null : CREDIT_CODE.trim();
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 电池维修更换时间
     */
    public Date getBUSINESS_DATE() {
        return BUSINESS_DATE;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性电池维修更换时间
     */
    public void setBUSINESS_DATE(Date BUSINESS_DATE) {
        this.BUSINESS_DATE = BUSINESS_DATE;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 创建者
     */
    public Integer getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性创建者
     */
    public void setCREATED_BY(Integer CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 创建时间
     */
    public Date getCREATED_TIME() {
        return CREATED_TIME;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性创建时间
     */
    public void setCREATED_TIME(Date CREATED_TIME) {
        this.CREATED_TIME = CREATED_TIME;
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 更新者
     */
    public Integer getUPDATED_BY() {
        return UPDATED_BY;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性更新者
     */
    public void setUPDATED_BY(Integer UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 更新时间
     */
    public Date getUPDATED_TIME() {
        return UPDATED_TIME;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性更新时间
     */
    public void setUPDATED_TIME(Date UPDATED_TIME) {
        this.UPDATED_TIME = UPDATED_TIME;
    }

    /**
     * 获取 [DT_AS_BATTERY_REPAIR_INFO] 的属性 数据版本
     */
    public Integer getVERSION() {
        return VERSION;
    }

    /**
     * 设置[DT_AS_BATTERY_REPAIR_INFO]的属性数据版本
     */
    public void setVERSION(Integer VERSION) {
        this.VERSION = VERSION;
    }
}