package com.zac.flycloud.bean.vos.request;

import com.zac.flycloud.bean.enums.PlatformEnum;
import lombok.Data;

@Data
public class MybatisGeneratorRequest {
    String dataBaseName;
    String tableName;
    String desc;
    PlatformEnum platform;
}
