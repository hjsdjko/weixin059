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


import com.cl.dao.JianchaleixingDao;
import com.cl.entity.JianchaleixingEntity;
import com.cl.service.JianchaleixingService;
import com.cl.entity.view.JianchaleixingView;

@Service("jianchaleixingService")
public class JianchaleixingServiceImpl extends ServiceImpl<JianchaleixingDao, JianchaleixingEntity> implements JianchaleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianchaleixingEntity> page = this.selectPage(
                new Query<JianchaleixingEntity>(params).getPage(),
                new EntityWrapper<JianchaleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianchaleixingEntity> wrapper) {
		  Page<JianchaleixingView> page =new Query<JianchaleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JianchaleixingView> selectListView(Wrapper<JianchaleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianchaleixingView selectView(Wrapper<JianchaleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
