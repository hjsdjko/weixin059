package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JianchabaogaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianchabaogaoView;


/**
 * 检查报告
 *
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
public interface JianchabaogaoService extends IService<JianchabaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianchabaogaoView> selectListView(Wrapper<JianchabaogaoEntity> wrapper);
   	
   	JianchabaogaoView selectView(@Param("ew") Wrapper<JianchabaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianchabaogaoEntity> wrapper);
   	

}

