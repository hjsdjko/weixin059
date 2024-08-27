package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiankangjihuaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangjihuaView;


/**
 * 健康计划
 *
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
public interface JiankangjihuaService extends IService<JiankangjihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangjihuaView> selectListView(Wrapper<JiankangjihuaEntity> wrapper);
   	
   	JiankangjihuaView selectView(@Param("ew") Wrapper<JiankangjihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangjihuaEntity> wrapper);
   	

}

