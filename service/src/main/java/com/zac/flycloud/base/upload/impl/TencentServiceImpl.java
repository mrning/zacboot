package com.zac.flycloud.base.upload.impl;

import com.alibaba.fastjson.JSONObject;
import com.zac.flycloud.base.upload.UploadFileService;
import org.springframework.web.multipart.MultipartFile;

public class TencentServiceImpl implements UploadFileService {

    @Override
    public JSONObject upload(MultipartFile file, String fileDir, String customBucket) {
        return null;
    }

    @Override
    public Object initOSS(String endpoint, String accessKeyId, String accessKeySecret) {
        return null;
    }
}
