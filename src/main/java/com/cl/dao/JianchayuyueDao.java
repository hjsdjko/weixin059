package com.cl.dao;

import com.cl.entity.JianchayuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianchayuyueView;


/**
 * 检查预约
 * 
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
public interface JianchayuyueDao extends BaseMapper<JianchayuyueEntity> {
	
	List<JianchayuyueView> selectListView(@Param("ew") Wrapper<JianchayuyueEntity> wrapper);

	List<JianchayuyueView> selectListView(Pagination page,@Param("ew") Wrapper<JianchayuyueEntity> wrapper);
	
	JianchayuyueView selectView(@Param("ew") Wrapper<JianchayuyueEntity> wrapper);
	

}
