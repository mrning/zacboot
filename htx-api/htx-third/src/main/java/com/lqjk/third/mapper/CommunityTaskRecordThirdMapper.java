package com.lqjk.third.mapper;

import com.lqjk.third.beans.CommunityTaskRecordThird;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author HZY
 * @description 任务参与记录
 * @date 2021-06-01
 */
@Mapper
@Repository
public interface CommunityTaskRecordThirdMapper {

    /**
     * 新增
     *
     * @author HZY
     * @date 2021/06/01
     **/
    int insert(CommunityTaskRecordThird communityTaskRecordThird);

    /**
     * 刪除
     *
     * @author HZY
     * @date 2021/06/01
     **/
    int delete(int id);

    /**
     * 更新
     *
     * @author HZY
     * @date 2021/06/01
     **/
    int update(CommunityTaskRecordThird communityTaskRecordThird);

    int addRecord(CommunityTaskRecordThird communityTaskRecordThird);

    /**
     * 查询 根据主键 id 查询
     *
     * @author HZY
     * @date 2021/06/01
     **/
    CommunityTaskRecordThird load(int id);

    /**
     * 查询 根据主键 用户ID 查询
     *
     * @author HZY
     * @date 2021/06/01
     **/
    CommunityTaskRecordThird selectOfUserIdAndTaskId(@Param("ownerId") Long id, @Param("taskId") String taskId,@Param("thirdChannel") String thirdChannel);

    Integer selectMetroDistance(@Param("ownerId") Long ownerId, @Param("taskId") String taskId,@Param("thirdChannel") String thirdChannel);
}