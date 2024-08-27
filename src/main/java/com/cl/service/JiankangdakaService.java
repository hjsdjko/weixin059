package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiankangdakaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangdakaView;


/**
 * 健康打卡
 *
 * @author 
 * @email 
 * @date 2024-03-11 09:09:16
 */
public interface JiankangdakaService extends IService<JiankangdakaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangdakaView> selectListView(Wrapper<JiankangdakaEntity> wrapper);
   	
   	JiankangdakaView selectView(@Param("ew") Wrapper<JiankangdakaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangdakaEntity> wrapper);
   	

}

