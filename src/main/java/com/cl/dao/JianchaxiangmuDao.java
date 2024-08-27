package com.cl.dao;

import com.cl.entity.JianchaxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianchaxiangmuView;


/**
 * 检查项目
 * 
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
public interface JianchaxiangmuDao extends BaseMapper<JianchaxiangmuEntity> {
	
	List<JianchaxiangmuView> selectListView(@Param("ew") Wrapper<JianchaxiangmuEntity> wrapper);

	List<JianchaxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<JianchaxiangmuEntity> wrapper);
	
	JianchaxiangmuView selectView(@Param("ew") Wrapper<JianchaxiangmuEntity> wrapper);
	

}
