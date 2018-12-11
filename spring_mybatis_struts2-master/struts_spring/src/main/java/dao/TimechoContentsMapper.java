package dao;

import entity.TimechoContents;
import entity.TimechoContentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TimechoContentsMapper {
    long countByExample(TimechoContentsExample example);

    int deleteByExample(TimechoContentsExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(TimechoContents record);

    int insertSelective(TimechoContents record);

    List<TimechoContents> selectByExampleWithBLOBsWithRowbounds(TimechoContentsExample example, RowBounds rowBounds);

    List<TimechoContents> selectByExampleWithBLOBs(TimechoContentsExample example);

    List<TimechoContents> selectByExampleWithRowbounds(TimechoContentsExample example, RowBounds rowBounds);

    List<TimechoContents> selectByExample(TimechoContentsExample example);

    TimechoContents selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") TimechoContents record, @Param("example") TimechoContentsExample example);

    int updateByExampleWithBLOBs(@Param("record") TimechoContents record, @Param("example") TimechoContentsExample example);

    int updateByExample(@Param("record") TimechoContents record, @Param("example") TimechoContentsExample example);

    int updateByPrimaryKeySelective(TimechoContents record);

    int updateByPrimaryKeyWithBLOBs(TimechoContents record);

    int updateByPrimaryKey(TimechoContents record);
}