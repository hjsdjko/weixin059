package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JianchaleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianchaleixingView;


/**
 * 检查类型
 *
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
public interface JianchaleixingService extends IService<JianchaleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianchaleixingView> selectListView(Wrapper<JianchaleixingEntity> wrapper);
   	
   	JianchaleixingView selectView(@Param("ew") Wrapper<JianchaleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianchaleixingEntity> wrapper);
   	

}

