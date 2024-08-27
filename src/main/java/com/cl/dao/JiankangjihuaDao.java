package com.cl.dao;

import com.cl.entity.JiankangjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangjihuaView;


/**
 * 健康计划
 * 
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
public interface JiankangjihuaDao extends BaseMapper<JiankangjihuaEntity> {
	
	List<JiankangjihuaView> selectListView(@Param("ew") Wrapper<JiankangjihuaEntity> wrapper);

	List<JiankangjihuaView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangjihuaEntity> wrapper);
	
	JiankangjihuaView selectView(@Param("ew") Wrapper<JiankangjihuaEntity> wrapper);
	

}
