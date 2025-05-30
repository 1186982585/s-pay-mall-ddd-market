package com.example.domain.tag.adapter.repository;

import com.example.domain.tag.model.entity.CrowdTagsJobEntity;

/**
 * @Author cxj
 * @Date 2025/5/29 16:30
 * @Description: 人群标签仓储接口
 */
public interface ITagRepository {

    CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId);

    void addCrowdTagsUserId(String tagId, String userId);

    void updateCrowdTagsStatistics(String tagId, int count);

}
