package com.example.domain.tag.service;

/**
 * @Author cxj
 * @Date 2025/5/29 16:27
 * @Description: 人群标签服务接口
 */
public interface ITagService {

    /**
     * 执行人群标签批次任务
     *
     * @param tagId   人群ID
     * @param batchId 批次ID
     */
    void execTagBatchJob(String tagId, String batchId);

}
