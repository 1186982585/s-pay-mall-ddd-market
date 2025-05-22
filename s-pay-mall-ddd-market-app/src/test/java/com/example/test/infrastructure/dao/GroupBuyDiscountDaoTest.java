package com.example.test.infrastructure.dao;

import com.alibaba.fastjson.JSON;
import com.example.infrastructure.dao.IGroupBuyDiscountDao;
import com.example.infrastructure.dao.po.GroupBuyDiscount;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author cxj
 * @Date 2025/5/22 14:34
 * @Description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupBuyDiscountDaoTest {

    @Resource
    private IGroupBuyDiscountDao groupBuyDiscountDao;

    @Test
    public void test_queryGroupBuyDiscountList(){
        List<GroupBuyDiscount> groupBuyDiscounts = groupBuyDiscountDao.queryGroupBuyDiscountList();
        log.info("测试结果:{}", JSON.toJSONString(groupBuyDiscounts));
    }
}
