package dao;

import java.util.List;

import entity.TimechoCommentsPlus;

public interface TimechoCommentsPlusMapper {
	List<TimechoCommentsPlus> selectCommentsById(Integer cid);
}
