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


import com.cl.dao.JianchabaogaoDao;
import com.cl.entity.JianchabaogaoEntity;
import com.cl.service.JianchabaogaoService;
import com.cl.entity.view.JianchabaogaoView;

@Service("jianchabaogaoService")
public class JianchabaogaoServiceImpl extends ServiceImpl<JianchabaogaoDao, JianchabaogaoEntity> implements JianchabaogaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianchabaogaoEntity> page = this.selectPage(
                new Query<JianchabaogaoEntity>(params).getPage(),
                new EntityWrapper<JianchabaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianchabaogaoEntity> wrapper) {
		  Page<JianchabaogaoView> page =new Query<JianchabaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JianchabaogaoView> selectListView(Wrapper<JianchabaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianchabaogaoView selectView(Wrapper<JianchabaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
