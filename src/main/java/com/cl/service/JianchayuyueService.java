package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JianchayuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianchayuyueView;


/**
 * 检查预约
 *
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
public interface JianchayuyueService extends IService<JianchayuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianchayuyueView> selectListView(Wrapper<JianchayuyueEntity> wrapper);
   	
   	JianchayuyueView selectView(@Param("ew") Wrapper<JianchayuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianchayuyueEntity> wrapper);
   	

}

