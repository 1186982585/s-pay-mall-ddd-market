package com.example.test.infrastructure.gateway;

import com.example.infrastructure.gateway.GroupBuyNotifyService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author cxj
 * @Date 2025/11/20 20:46
 * @Description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupBuyNotifyServiceTest {

    @Resource
    private GroupBuyNotifyService groupBuyNotifyService;

    @Test
    public void test_notify_api() throws Exception {

        String notifyRequestDTOJSON = "{\"teamId\":\"57199993\",\"outTradeNoList\":\"038426231487,652896391719,619401409195\"}";
        String notifyRequestDTOJSON2 = "{\"teamId\":\"91723348\",\"outTradeNoList\":[\"485928388543\",\"675993290638\",\"522954206954\"]}";

        String response = groupBuyNotifyService.groupBuyNotify("http://127.0.0.1:8091/api/v1/test/group_buy_notify", notifyRequestDTOJSON2);

        log.info("测试结果:{}", response);
    }

    @Test
    public void test() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"teamId\":\"91723348\",\"outTradeNoList\":\"485928388543,675993290638,522954206954\"}");
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8091/api/v1/test/group_buy_notify")
                .post(body)
                .addHeader("content-type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        log.info("测试结果:{}", response);
    }
}
