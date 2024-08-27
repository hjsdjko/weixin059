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


import com.cl.dao.JianchayuyueDao;
import com.cl.entity.JianchayuyueEntity;
import com.cl.service.JianchayuyueService;
import com.cl.entity.view.JianchayuyueView;

@Service("jianchayuyueService")
public class JianchayuyueServiceImpl extends ServiceImpl<JianchayuyueDao, JianchayuyueEntity> implements JianchayuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianchayuyueEntity> page = this.selectPage(
                new Query<JianchayuyueEntity>(params).getPage(),
                new EntityWrapper<JianchayuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianchayuyueEntity> wrapper) {
		  Page<JianchayuyueView> page =new Query<JianchayuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JianchayuyueView> selectListView(Wrapper<JianchayuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianchayuyueView selectView(Wrapper<JianchayuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
