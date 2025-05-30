package com.example.infrastructure.dao;

import com.example.infrastructure.dao.po.CrowdTags;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author cxj
 * @Date 2025/5/29 16:46
 * @Description: 人群标签
 */
@Mapper
public interface ICrowdTagsDao {

    void updateCrowdTagsStatistics(CrowdTags crowdTagsReq);

}
