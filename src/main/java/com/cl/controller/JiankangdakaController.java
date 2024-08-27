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

import com.cl.entity.JiankangdakaEntity;
import com.cl.entity.view.JiankangdakaView;

import com.cl.service.JiankangdakaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康打卡
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 09:09:16
 */
@RestController
@RequestMapping("/jiankangdaka")
public class JiankangdakaController {
    @Autowired
    private JiankangdakaService jiankangdakaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangdakaEntity jiankangdaka,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiankangdaka.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiankangdakaEntity> ew = new EntityWrapper<JiankangdakaEntity>();

		PageUtils page = jiankangdakaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangdaka), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankangdakaEntity jiankangdaka, 
		HttpServletRequest request){
        EntityWrapper<JiankangdakaEntity> ew = new EntityWrapper<JiankangdakaEntity>();

		PageUtils page = jiankangdakaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangdaka), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangdakaEntity jiankangdaka){
       	EntityWrapper<JiankangdakaEntity> ew = new EntityWrapper<JiankangdakaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangdaka, "jiankangdaka")); 
        return R.ok().put("data", jiankangdakaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangdakaEntity jiankangdaka){
        EntityWrapper< JiankangdakaEntity> ew = new EntityWrapper< JiankangdakaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangdaka, "jiankangdaka")); 
		JiankangdakaView jiankangdakaView =  jiankangdakaService.selectView(ew);
		return R.ok("查询健康打卡成功").put("data", jiankangdakaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangdakaEntity jiankangdaka = jiankangdakaService.selectById(id);
		jiankangdaka = jiankangdakaService.selectView(new EntityWrapper<JiankangdakaEntity>().eq("id", id));
        return R.ok().put("data", jiankangdaka);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangdakaEntity jiankangdaka = jiankangdakaService.selectById(id);
		jiankangdaka = jiankangdakaService.selectView(new EntityWrapper<JiankangdakaEntity>().eq("id", id));
        return R.ok().put("data", jiankangdaka);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangdakaEntity jiankangdaka, HttpServletRequest request){
    	jiankangdaka.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangdaka);
        jiankangdakaService.insert(jiankangdaka);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangdakaEntity jiankangdaka, HttpServletRequest request){
    	jiankangdaka.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangdaka);
        jiankangdakaService.insert(jiankangdaka);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangdakaEntity jiankangdaka, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangdaka);
        jiankangdakaService.updateById(jiankangdaka);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangdakaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
