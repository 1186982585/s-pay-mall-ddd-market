package com.example.infrastructure.dao;

import com.example.infrastructure.dao.po.NotifyTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author cxj
 * @Date 2025/11/19 15:03
 * @Description:
 */
@Mapper
public interface INotifyTaskDao {

    void insert(NotifyTask notifyTask);

    List<NotifyTask> queryUnExecutedNotifyTaskList();

    NotifyTask queryUnExecutedNotifyTaskByTeamId(String teamId);

    int updateNotifyTaskStatusSuccess(String teamId);

    int updateNotifyTaskStatusError(String teamId);

    int updateNotifyTaskStatusRetry(String teamId);

}
