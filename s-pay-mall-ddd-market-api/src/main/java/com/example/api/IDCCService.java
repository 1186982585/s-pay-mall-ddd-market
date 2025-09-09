package com.example.api;

import com.example.api.response.Response;

/**
 * @Author cxj
 * @Date 2025/9/9 14:56
 * @Description:
 */
public interface IDCCService {

    Response<Boolean> updateConfig(String key, String value);

}
