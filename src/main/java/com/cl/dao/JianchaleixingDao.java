package com.cl.dao;

import com.cl.entity.JianchaleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianchaleixingView;


/**
 * 检查类型
 * 
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
public interface JianchaleixingDao extends BaseMapper<JianchaleixingEntity> {
	
	List<JianchaleixingView> selectListView(@Param("ew") Wrapper<JianchaleixingEntity> wrapper);

	List<JianchaleixingView> selectListView(Pagination page,@Param("ew") Wrapper<JianchaleixingEntity> wrapper);
	
	JianchaleixingView selectView(@Param("ew") Wrapper<JianchaleixingEntity> wrapper);
	

}
