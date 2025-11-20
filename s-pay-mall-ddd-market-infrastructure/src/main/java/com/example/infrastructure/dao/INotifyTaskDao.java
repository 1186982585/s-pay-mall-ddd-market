package com.example.infrastructure.dao;

import com.example.infrastructure.dao.po.NotifyTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author cxj
 * @Date 2025/11/19 15:03
 * @Description:
 */
@Mapper
public interface INotifyTaskDao {

    void insert(NotifyTask notifyTask);

}
