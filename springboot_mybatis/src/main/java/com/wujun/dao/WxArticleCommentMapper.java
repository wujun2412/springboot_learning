package com.wujun.dao;

import com.wujun.domain.WxArticleComment;

public interface WxArticleCommentMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(WxArticleComment record);

    int insertSelective(WxArticleComment record);

    WxArticleComment selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(WxArticleComment record);

    int updateByPrimaryKey(WxArticleComment record);
}