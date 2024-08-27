package com.cl.dao;

import com.cl.entity.JiankangdakaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangdakaView;


/**
 * 健康打卡
 * 
 * @author 
 * @email 
 * @date 2024-03-11 09:09:16
 */
public interface JiankangdakaDao extends BaseMapper<JiankangdakaEntity> {
	
	List<JiankangdakaView> selectListView(@Param("ew") Wrapper<JiankangdakaEntity> wrapper);

	List<JiankangdakaView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangdakaEntity> wrapper);
	
	JiankangdakaView selectView(@Param("ew") Wrapper<JiankangdakaEntity> wrapper);
	

}
