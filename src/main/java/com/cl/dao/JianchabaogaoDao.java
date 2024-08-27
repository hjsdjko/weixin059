package com.cl.dao;

import com.cl.entity.JianchabaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianchabaogaoView;


/**
 * 检查报告
 * 
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
public interface JianchabaogaoDao extends BaseMapper<JianchabaogaoEntity> {
	
	List<JianchabaogaoView> selectListView(@Param("ew") Wrapper<JianchabaogaoEntity> wrapper);

	List<JianchabaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<JianchabaogaoEntity> wrapper);
	
	JianchabaogaoView selectView(@Param("ew") Wrapper<JianchabaogaoEntity> wrapper);
	

}
