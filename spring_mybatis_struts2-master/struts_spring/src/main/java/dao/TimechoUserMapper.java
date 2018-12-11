package dao;

import entity.TimechoUser;
import entity.TimechoUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TimechoUserMapper {
    long countByExample(TimechoUserExample example);

    int deleteByExample(TimechoUserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(TimechoUser record);

    int insertSelective(TimechoUser record);

    List<TimechoUser> selectByExampleWithRowbounds(TimechoUserExample example, RowBounds rowBounds);

    List<TimechoUser> selectByExample(TimechoUserExample example);

    TimechoUser selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") TimechoUser record, @Param("example") TimechoUserExample example);

    int updateByExample(@Param("record") TimechoUser record, @Param("example") TimechoUserExample example);

    int updateByPrimaryKeySelective(TimechoUser record);

    int updateByPrimaryKey(TimechoUser record);
}