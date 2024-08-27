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

import com.cl.entity.JiankangjihuaEntity;
import com.cl.entity.view.JiankangjihuaView;

import com.cl.service.JiankangjihuaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康计划
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
@RestController
@RequestMapping("/jiankangjihua")
public class JiankangjihuaController {
    @Autowired
    private JiankangjihuaService jiankangjihuaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangjihuaEntity jiankangjihua,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiankangjihua.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiankangjihuaEntity> ew = new EntityWrapper<JiankangjihuaEntity>();

		PageUtils page = jiankangjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangjihua), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankangjihuaEntity jiankangjihua, 
		HttpServletRequest request){
        EntityWrapper<JiankangjihuaEntity> ew = new EntityWrapper<JiankangjihuaEntity>();

		PageUtils page = jiankangjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangjihua), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangjihuaEntity jiankangjihua){
       	EntityWrapper<JiankangjihuaEntity> ew = new EntityWrapper<JiankangjihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangjihua, "jiankangjihua")); 
        return R.ok().put("data", jiankangjihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangjihuaEntity jiankangjihua){
        EntityWrapper< JiankangjihuaEntity> ew = new EntityWrapper< JiankangjihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangjihua, "jiankangjihua")); 
		JiankangjihuaView jiankangjihuaView =  jiankangjihuaService.selectView(ew);
		return R.ok("查询健康计划成功").put("data", jiankangjihuaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangjihuaEntity jiankangjihua = jiankangjihuaService.selectById(id);
		jiankangjihua = jiankangjihuaService.selectView(new EntityWrapper<JiankangjihuaEntity>().eq("id", id));
        return R.ok().put("data", jiankangjihua);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangjihuaEntity jiankangjihua = jiankangjihuaService.selectById(id);
		jiankangjihua = jiankangjihuaService.selectView(new EntityWrapper<JiankangjihuaEntity>().eq("id", id));
        return R.ok().put("data", jiankangjihua);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangjihuaEntity jiankangjihua, HttpServletRequest request){
    	jiankangjihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangjihua);
        jiankangjihuaService.insert(jiankangjihua);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangjihuaEntity jiankangjihua, HttpServletRequest request){
    	jiankangjihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangjihua);
        jiankangjihuaService.insert(jiankangjihua);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangjihuaEntity jiankangjihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangjihua);
        jiankangjihuaService.updateById(jiankangjihua);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangjihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
