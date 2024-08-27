package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JianchaxiangmuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianchaxiangmuView;


/**
 * 检查项目
 *
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
public interface JianchaxiangmuService extends IService<JianchaxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianchaxiangmuView> selectListView(Wrapper<JianchaxiangmuEntity> wrapper);
   	
   	JianchaxiangmuView selectView(@Param("ew") Wrapper<JianchaxiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianchaxiangmuEntity> wrapper);
   	

}

