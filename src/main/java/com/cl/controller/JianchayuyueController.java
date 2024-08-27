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

import com.cl.entity.JianchayuyueEntity;
import com.cl.entity.view.JianchayuyueView;

import com.cl.service.JianchayuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 检查预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
@RestController
@RequestMapping("/jianchayuyue")
public class JianchayuyueController {
    @Autowired
    private JianchayuyueService jianchayuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianchayuyueEntity jianchayuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jianchayuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yisheng")) {
			jianchayuyue.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianchayuyueEntity> ew = new EntityWrapper<JianchayuyueEntity>();

		PageUtils page = jianchayuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianchayuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianchayuyueEntity jianchayuyue, 
		HttpServletRequest request){
        EntityWrapper<JianchayuyueEntity> ew = new EntityWrapper<JianchayuyueEntity>();

		PageUtils page = jianchayuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianchayuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianchayuyueEntity jianchayuyue){
       	EntityWrapper<JianchayuyueEntity> ew = new EntityWrapper<JianchayuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianchayuyue, "jianchayuyue")); 
        return R.ok().put("data", jianchayuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianchayuyueEntity jianchayuyue){
        EntityWrapper< JianchayuyueEntity> ew = new EntityWrapper< JianchayuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianchayuyue, "jianchayuyue")); 
		JianchayuyueView jianchayuyueView =  jianchayuyueService.selectView(ew);
		return R.ok("查询检查预约成功").put("data", jianchayuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianchayuyueEntity jianchayuyue = jianchayuyueService.selectById(id);
		jianchayuyue = jianchayuyueService.selectView(new EntityWrapper<JianchayuyueEntity>().eq("id", id));
        return R.ok().put("data", jianchayuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianchayuyueEntity jianchayuyue = jianchayuyueService.selectById(id);
		jianchayuyue = jianchayuyueService.selectView(new EntityWrapper<JianchayuyueEntity>().eq("id", id));
        return R.ok().put("data", jianchayuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianchayuyueEntity jianchayuyue, HttpServletRequest request){
    	jianchayuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianchayuyue);
        jianchayuyueService.insert(jianchayuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianchayuyueEntity jianchayuyue, HttpServletRequest request){
    	jianchayuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianchayuyue);
        jianchayuyueService.insert(jianchayuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianchayuyueEntity jianchayuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianchayuyue);
        jianchayuyueService.updateById(jianchayuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianchayuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
