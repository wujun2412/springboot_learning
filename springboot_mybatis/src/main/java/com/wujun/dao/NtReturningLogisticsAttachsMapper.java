package com.wujun.dao;

import com.wujun.domain.NtReturningLogisticsAttachs;

public interface NtReturningLogisticsAttachsMapper {
    int deleteByPrimaryKey(Long ATTACHMENT_ID);

    int insert(NtReturningLogisticsAttachs record);

    int insertSelective(NtReturningLogisticsAttachs record);

    NtReturningLogisticsAttachs selectByPrimaryKey(Long ATTACHMENT_ID);

    int updateByPrimaryKeySelective(NtReturningLogisticsAttachs record);

    int updateByPrimaryKey(NtReturningLogisticsAttachs record);
}