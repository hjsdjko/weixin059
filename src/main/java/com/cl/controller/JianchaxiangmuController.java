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

import com.cl.entity.JianchaxiangmuEntity;
import com.cl.entity.view.JianchaxiangmuView;

import com.cl.service.JianchaxiangmuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 检查项目
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
@RestController
@RequestMapping("/jianchaxiangmu")
public class JianchaxiangmuController {
    @Autowired
    private JianchaxiangmuService jianchaxiangmuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianchaxiangmuEntity jianchaxiangmu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			jianchaxiangmu.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianchaxiangmuEntity> ew = new EntityWrapper<JianchaxiangmuEntity>();

		PageUtils page = jianchaxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianchaxiangmu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianchaxiangmuEntity jianchaxiangmu, 
		HttpServletRequest request){
        EntityWrapper<JianchaxiangmuEntity> ew = new EntityWrapper<JianchaxiangmuEntity>();

		PageUtils page = jianchaxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianchaxiangmu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianchaxiangmuEntity jianchaxiangmu){
       	EntityWrapper<JianchaxiangmuEntity> ew = new EntityWrapper<JianchaxiangmuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianchaxiangmu, "jianchaxiangmu")); 
        return R.ok().put("data", jianchaxiangmuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianchaxiangmuEntity jianchaxiangmu){
        EntityWrapper< JianchaxiangmuEntity> ew = new EntityWrapper< JianchaxiangmuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianchaxiangmu, "jianchaxiangmu")); 
		JianchaxiangmuView jianchaxiangmuView =  jianchaxiangmuService.selectView(ew);
		return R.ok("查询检查项目成功").put("data", jianchaxiangmuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianchaxiangmuEntity jianchaxiangmu = jianchaxiangmuService.selectById(id);
		jianchaxiangmu = jianchaxiangmuService.selectView(new EntityWrapper<JianchaxiangmuEntity>().eq("id", id));
        return R.ok().put("data", jianchaxiangmu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianchaxiangmuEntity jianchaxiangmu = jianchaxiangmuService.selectById(id);
		jianchaxiangmu = jianchaxiangmuService.selectView(new EntityWrapper<JianchaxiangmuEntity>().eq("id", id));
        return R.ok().put("data", jianchaxiangmu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianchaxiangmuEntity jianchaxiangmu, HttpServletRequest request){
    	jianchaxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianchaxiangmu);
        jianchaxiangmuService.insert(jianchaxiangmu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianchaxiangmuEntity jianchaxiangmu, HttpServletRequest request){
    	jianchaxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianchaxiangmu);
        jianchaxiangmuService.insert(jianchaxiangmu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianchaxiangmuEntity jianchaxiangmu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianchaxiangmu);
        jianchaxiangmuService.updateById(jianchaxiangmu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianchaxiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
