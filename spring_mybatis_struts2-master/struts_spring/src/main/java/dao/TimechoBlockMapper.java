package dao;

import entity.TimechoBlock;
import entity.TimechoBlockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TimechoBlockMapper {
    long countByExample(TimechoBlockExample example);

    int deleteByExample(TimechoBlockExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(TimechoBlock record);

    int insertSelective(TimechoBlock record);

    List<TimechoBlock> selectByExampleWithRowbounds(TimechoBlockExample example, RowBounds rowBounds);

    List<TimechoBlock> selectByExample(TimechoBlockExample example);

    TimechoBlock selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") TimechoBlock record, @Param("example") TimechoBlockExample example);

    int updateByExample(@Param("record") TimechoBlock record, @Param("example") TimechoBlockExample example);

    int updateByPrimaryKeySelective(TimechoBlock record);

    int updateByPrimaryKey(TimechoBlock record);
}