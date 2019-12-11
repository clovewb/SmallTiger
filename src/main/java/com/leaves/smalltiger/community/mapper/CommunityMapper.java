package com.leaves.smalltiger.community.mapper;

import com.leaves.smalltiger.common.config.BaseMapper;
import com.leaves.smalltiger.common.po.Community;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommunityMapper extends BaseMapper<Community> {
    /**
     * 查询所有状态为1的评论
     * @param
     * @return
     */
    @Select("SELECT * FROM community WHERE msgStatus = 1 order by msgCTime desc")
    public List<Community> selectCommunitiesByMsgStatus();

    //后台
    /**
     * 根据msgId删除一条留言(实际为改变该留言状态)
     * @param
     */
    @Select("update community set msgStatus = 0 where msgId = #{msgId}")
    public void deleteCommunityByMsgId (@Param("msgId")int msgId);


    /**
     * 模糊查询
     * @param msgWords
     * @return
     */
    @Select("select * from community where msgWords like '%${msgWords}%'")
    public List<Community> selectCommodityByWords(@Param("msgWords")String msgWords);

    /**
     * 恢复留言
     * @param msgId
     */
    @Select("update community set msgStatus=1 where msgId=#{msgId}")
    public void resumeCommunityByMsgId(@Param("msgId")int msgId);
}
