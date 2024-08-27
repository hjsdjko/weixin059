package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JianchaxiangmuDao;
import com.cl.entity.JianchaxiangmuEntity;
import com.cl.service.JianchaxiangmuService;
import com.cl.entity.view.JianchaxiangmuView;

@Service("jianchaxiangmuService")
public class JianchaxiangmuServiceImpl extends ServiceImpl<JianchaxiangmuDao, JianchaxiangmuEntity> implements JianchaxiangmuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianchaxiangmuEntity> page = this.selectPage(
                new Query<JianchaxiangmuEntity>(params).getPage(),
                new EntityWrapper<JianchaxiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianchaxiangmuEntity> wrapper) {
		  Page<JianchaxiangmuView> page =new Query<JianchaxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JianchaxiangmuView> selectListView(Wrapper<JianchaxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianchaxiangmuView selectView(Wrapper<JianchaxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
