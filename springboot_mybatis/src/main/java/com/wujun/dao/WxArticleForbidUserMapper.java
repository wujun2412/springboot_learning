package com.wujun.dao;

import com.wujun.domain.WxArticleForbidUser;

public interface WxArticleForbidUserMapper {
    int deleteByPrimaryKey(Long forbidId);

    int insert(WxArticleForbidUser record);

    int insertSelective(WxArticleForbidUser record);

    WxArticleForbidUser selectByPrimaryKey(Long forbidId);

    int updateByPrimaryKeySelective(WxArticleForbidUser record);

    int updateByPrimaryKey(WxArticleForbidUser record);
}