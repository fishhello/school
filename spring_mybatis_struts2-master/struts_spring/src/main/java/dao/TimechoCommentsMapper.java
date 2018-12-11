package dao;

import entity.TimechoComments;
import entity.TimechoCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TimechoCommentsMapper {
    long countByExample(TimechoCommentsExample example);

    int deleteByExample(TimechoCommentsExample example);

    int deleteByPrimaryKey(Integer coid);

    int insert(TimechoComments record);

    int insertSelective(TimechoComments record);

    List<TimechoComments> selectByExampleWithBLOBsWithRowbounds(TimechoCommentsExample example, RowBounds rowBounds);

    List<TimechoComments> selectByExampleWithBLOBs(TimechoCommentsExample example);

    List<TimechoComments> selectByExampleWithRowbounds(TimechoCommentsExample example, RowBounds rowBounds);

    List<TimechoComments> selectByExample(TimechoCommentsExample example);

    TimechoComments selectByPrimaryKey(Integer coid);

    int updateByExampleSelective(@Param("record") TimechoComments record, @Param("example") TimechoCommentsExample example);

    int updateByExampleWithBLOBs(@Param("record") TimechoComments record, @Param("example") TimechoCommentsExample example);

    int updateByExample(@Param("record") TimechoComments record, @Param("example") TimechoCommentsExample example);

    int updateByPrimaryKeySelective(TimechoComments record);

    int updateByPrimaryKeyWithBLOBs(TimechoComments record);

    int updateByPrimaryKey(TimechoComments record);
}