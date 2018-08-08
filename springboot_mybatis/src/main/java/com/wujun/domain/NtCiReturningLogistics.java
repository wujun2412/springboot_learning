package com.wujun.domain;

import java.util.Date;

public class NtCiReturningLogistics {
    /**
     * 物流ID
     */
    private Long LOGISTICS_ID;

    /**
     * 公司ID
     */
    private Integer COMPANY_ID;

    /**
     * 服务站(经销商)ID号
     */
    private Integer DEALER_ID;

    /**
     * 服务站(经销商)代码
     */
    private String DEALER_CODE;

    /**
     * 服务站(经销商)简称
     */
    private String DEALER_SHORT_NAME;

    /**
     * 箱ID
     */
    private Long BOX_ID;

    /**
     * 箱号
     */
    private String CASE_NO;

    private String RETURNING_NO;

    /**
     * 发运日期
     */
    private Date SHIPPED_DATE;

    /**
     * 服务站索赔办事处（字典2005）
     */
    private Integer CI_OFFICE_DLR;

    /**
     * 索赔办事处名称
     */
    private String CI_OFFICE_DLR_NAME;

    /**
     * 集散中心代码
     */
    private String POT_CODE;

    /**
     * 集散中心名称
     */
    private String POT_NAME;

    /**
     * 集散中心扫描入库日期
     */
    private Date ENTRY_DATE;

    /**
     * 入库人
     */
    private Integer ENTRY_BY;

    /**
     * 是否入库,0:未入库 1:已入库
     */
    private Short IS_ENTRY;

    /**
     * 是否手工入库,0:否 1:是
     */
    private Short IS_MANUL_ENTRY;

    /**
     * 集散中心扫描出库日期
     */
    private Date OUT_DATE;

    /**
     * 出库人
     */
    private Integer OUT_BY;

    /**
     * 是否出库,0:否 1:是
     */
    private Short IS_OUT;

    /**
     * 是否手工出库,0:否 1:是
     */
    private Short IS_MANUL_OUT;

    /**
     * 车厂验收日期
     */
    private Date ACCEPTANCE_DATE;

    /**
     * 验收人
     */
    private Integer ACCEPTANCE_BY;

    /**
     * 是否验收,0:未验收 1:已验收
     */
    private Short IS_ACCEPTANCE;

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
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 物流ID
     */
    public Long getLOGISTICS_ID() {
        return LOGISTICS_ID;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性物流ID
     */
    public void setLOGISTICS_ID(Long LOGISTICS_ID) {
        this.LOGISTICS_ID = LOGISTICS_ID;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 公司ID
     */
    public Integer getCOMPANY_ID() {
        return COMPANY_ID;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性公司ID
     */
    public void setCOMPANY_ID(Integer COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 服务站(经销商)ID号
     */
    public Integer getDEALER_ID() {
        return DEALER_ID;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性服务站(经销商)ID号
     */
    public void setDEALER_ID(Integer DEALER_ID) {
        this.DEALER_ID = DEALER_ID;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 服务站(经销商)代码
     */
    public String getDEALER_CODE() {
        return DEALER_CODE;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性服务站(经销商)代码
     */
    public void setDEALER_CODE(String DEALER_CODE) {
        this.DEALER_CODE = DEALER_CODE == null ? null : DEALER_CODE.trim();
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 服务站(经销商)简称
     */
    public String getDEALER_SHORT_NAME() {
        return DEALER_SHORT_NAME;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性服务站(经销商)简称
     */
    public void setDEALER_SHORT_NAME(String DEALER_SHORT_NAME) {
        this.DEALER_SHORT_NAME = DEALER_SHORT_NAME == null ? null : DEALER_SHORT_NAME.trim();
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 箱ID
     */
    public Long getBOX_ID() {
        return BOX_ID;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性箱ID
     */
    public void setBOX_ID(Long BOX_ID) {
        this.BOX_ID = BOX_ID;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 箱号
     */
    public String getCASE_NO() {
        return CASE_NO;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性箱号
     */
    public void setCASE_NO(String CASE_NO) {
        this.CASE_NO = CASE_NO == null ? null : CASE_NO.trim();
    }

    public String getRETURNING_NO() {
        return RETURNING_NO;
    }

    public void setRETURNING_NO(String RETURNING_NO) {
        this.RETURNING_NO = RETURNING_NO == null ? null : RETURNING_NO.trim();
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 发运日期
     */
    public Date getSHIPPED_DATE() {
        return SHIPPED_DATE;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性发运日期
     */
    public void setSHIPPED_DATE(Date SHIPPED_DATE) {
        this.SHIPPED_DATE = SHIPPED_DATE;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 服务站索赔办事处（字典2005）
     */
    public Integer getCI_OFFICE_DLR() {
        return CI_OFFICE_DLR;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性服务站索赔办事处（字典2005）
     */
    public void setCI_OFFICE_DLR(Integer CI_OFFICE_DLR) {
        this.CI_OFFICE_DLR = CI_OFFICE_DLR;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 索赔办事处名称
     */
    public String getCI_OFFICE_DLR_NAME() {
        return CI_OFFICE_DLR_NAME;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性索赔办事处名称
     */
    public void setCI_OFFICE_DLR_NAME(String CI_OFFICE_DLR_NAME) {
        this.CI_OFFICE_DLR_NAME = CI_OFFICE_DLR_NAME == null ? null : CI_OFFICE_DLR_NAME.trim();
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 集散中心代码
     */
    public String getPOT_CODE() {
        return POT_CODE;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性集散中心代码
     */
    public void setPOT_CODE(String POT_CODE) {
        this.POT_CODE = POT_CODE == null ? null : POT_CODE.trim();
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 集散中心名称
     */
    public String getPOT_NAME() {
        return POT_NAME;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性集散中心名称
     */
    public void setPOT_NAME(String POT_NAME) {
        this.POT_NAME = POT_NAME == null ? null : POT_NAME.trim();
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 集散中心扫描入库日期
     */
    public Date getENTRY_DATE() {
        return ENTRY_DATE;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性集散中心扫描入库日期
     */
    public void setENTRY_DATE(Date ENTRY_DATE) {
        this.ENTRY_DATE = ENTRY_DATE;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 入库人
     */
    public Integer getENTRY_BY() {
        return ENTRY_BY;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性入库人
     */
    public void setENTRY_BY(Integer ENTRY_BY) {
        this.ENTRY_BY = ENTRY_BY;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 是否入库,0:未入库 1:已入库
     */
    public Short getIS_ENTRY() {
        return IS_ENTRY;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性是否入库,0:未入库 1:已入库
     */
    public void setIS_ENTRY(Short IS_ENTRY) {
        this.IS_ENTRY = IS_ENTRY;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 是否手工入库,0:否 1:是
     */
    public Short getIS_MANUL_ENTRY() {
        return IS_MANUL_ENTRY;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性是否手工入库,0:否 1:是
     */
    public void setIS_MANUL_ENTRY(Short IS_MANUL_ENTRY) {
        this.IS_MANUL_ENTRY = IS_MANUL_ENTRY;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 集散中心扫描出库日期
     */
    public Date getOUT_DATE() {
        return OUT_DATE;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性集散中心扫描出库日期
     */
    public void setOUT_DATE(Date OUT_DATE) {
        this.OUT_DATE = OUT_DATE;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 出库人
     */
    public Integer getOUT_BY() {
        return OUT_BY;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性出库人
     */
    public void setOUT_BY(Integer OUT_BY) {
        this.OUT_BY = OUT_BY;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 是否出库,0:否 1:是
     */
    public Short getIS_OUT() {
        return IS_OUT;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性是否出库,0:否 1:是
     */
    public void setIS_OUT(Short IS_OUT) {
        this.IS_OUT = IS_OUT;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 是否手工出库,0:否 1:是
     */
    public Short getIS_MANUL_OUT() {
        return IS_MANUL_OUT;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性是否手工出库,0:否 1:是
     */
    public void setIS_MANUL_OUT(Short IS_MANUL_OUT) {
        this.IS_MANUL_OUT = IS_MANUL_OUT;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 车厂验收日期
     */
    public Date getACCEPTANCE_DATE() {
        return ACCEPTANCE_DATE;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性车厂验收日期
     */
    public void setACCEPTANCE_DATE(Date ACCEPTANCE_DATE) {
        this.ACCEPTANCE_DATE = ACCEPTANCE_DATE;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 验收人
     */
    public Integer getACCEPTANCE_BY() {
        return ACCEPTANCE_BY;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性验收人
     */
    public void setACCEPTANCE_BY(Integer ACCEPTANCE_BY) {
        this.ACCEPTANCE_BY = ACCEPTANCE_BY;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 是否验收,0:未验收 1:已验收
     */
    public Short getIS_ACCEPTANCE() {
        return IS_ACCEPTANCE;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性是否验收,0:未验收 1:已验收
     */
    public void setIS_ACCEPTANCE(Short IS_ACCEPTANCE) {
        this.IS_ACCEPTANCE = IS_ACCEPTANCE;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 备注
     */
    public String getREMARK() {
        return REMARK;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性备注
     */
    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 创建者
     */
    public Integer getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性创建者
     */
    public void setCREATED_BY(Integer CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 创建时间
     */
    public Date getCREATED_TIME() {
        return CREATED_TIME;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性创建时间
     */
    public void setCREATED_TIME(Date CREATED_TIME) {
        this.CREATED_TIME = CREATED_TIME;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 更新者
     */
    public Integer getUPDATED_BY() {
        return UPDATED_BY;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性更新者
     */
    public void setUPDATED_BY(Integer UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 更新时间
     */
    public Date getUPDATED_TIME() {
        return UPDATED_TIME;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性更新时间
     */
    public void setUPDATED_TIME(Date UPDATED_TIME) {
        this.UPDATED_TIME = UPDATED_TIME;
    }

    /**
     * 获取 [NT_CI_RETURNING_LOGISTICS] 的属性 数据版本
     */
    public Integer getVERSION() {
        return VERSION;
    }

    /**
     * 设置[NT_CI_RETURNING_LOGISTICS]的属性数据版本
     */
    public void setVERSION(Integer VERSION) {
        this.VERSION = VERSION;
    }
}