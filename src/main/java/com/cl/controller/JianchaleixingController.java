package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JianchaleixingEntity;
import com.cl.entity.view.JianchaleixingView;

import com.cl.service.JianchaleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 检查类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
@RestController
@RequestMapping("/jianchaleixing")
public class JianchaleixingController {
    @Autowired
    private JianchaleixingService jianchaleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianchaleixingEntity jianchaleixing,
		HttpServletRequest request){
        EntityWrapper<JianchaleixingEntity> ew = new EntityWrapper<JianchaleixingEntity>();

		PageUtils page = jianchaleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianchaleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianchaleixingEntity jianchaleixing, 
		HttpServletRequest request){
        EntityWrapper<JianchaleixingEntity> ew = new EntityWrapper<JianchaleixingEntity>();

		PageUtils page = jianchaleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianchaleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianchaleixingEntity jianchaleixing){
       	EntityWrapper<JianchaleixingEntity> ew = new EntityWrapper<JianchaleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianchaleixing, "jianchaleixing")); 
        return R.ok().put("data", jianchaleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianchaleixingEntity jianchaleixing){
        EntityWrapper< JianchaleixingEntity> ew = new EntityWrapper< JianchaleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianchaleixing, "jianchaleixing")); 
		JianchaleixingView jianchaleixingView =  jianchaleixingService.selectView(ew);
		return R.ok("查询检查类型成功").put("data", jianchaleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianchaleixingEntity jianchaleixing = jianchaleixingService.selectById(id);
		jianchaleixing = jianchaleixingService.selectView(new EntityWrapper<JianchaleixingEntity>().eq("id", id));
        return R.ok().put("data", jianchaleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianchaleixingEntity jianchaleixing = jianchaleixingService.selectById(id);
		jianchaleixing = jianchaleixingService.selectView(new EntityWrapper<JianchaleixingEntity>().eq("id", id));
        return R.ok().put("data", jianchaleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianchaleixingEntity jianchaleixing, HttpServletRequest request){
    	jianchaleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianchaleixing);
        jianchaleixingService.insert(jianchaleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianchaleixingEntity jianchaleixing, HttpServletRequest request){
    	jianchaleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianchaleixing);
        jianchaleixingService.insert(jianchaleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianchaleixingEntity jianchaleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianchaleixing);
        jianchaleixingService.updateById(jianchaleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianchaleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
