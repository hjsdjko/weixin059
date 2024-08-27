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

import com.cl.entity.JianchabaogaoEntity;
import com.cl.entity.view.JianchabaogaoView;

import com.cl.service.JianchabaogaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 检查报告
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 09:09:15
 */
@RestController
@RequestMapping("/jianchabaogao")
public class JianchabaogaoController {
    @Autowired
    private JianchabaogaoService jianchabaogaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianchabaogaoEntity jianchabaogao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jianchabaogao.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yisheng")) {
			jianchabaogao.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianchabaogaoEntity> ew = new EntityWrapper<JianchabaogaoEntity>();

		PageUtils page = jianchabaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianchabaogao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianchabaogaoEntity jianchabaogao, 
		HttpServletRequest request){
        EntityWrapper<JianchabaogaoEntity> ew = new EntityWrapper<JianchabaogaoEntity>();

		PageUtils page = jianchabaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianchabaogao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianchabaogaoEntity jianchabaogao){
       	EntityWrapper<JianchabaogaoEntity> ew = new EntityWrapper<JianchabaogaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianchabaogao, "jianchabaogao")); 
        return R.ok().put("data", jianchabaogaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianchabaogaoEntity jianchabaogao){
        EntityWrapper< JianchabaogaoEntity> ew = new EntityWrapper< JianchabaogaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianchabaogao, "jianchabaogao")); 
		JianchabaogaoView jianchabaogaoView =  jianchabaogaoService.selectView(ew);
		return R.ok("查询检查报告成功").put("data", jianchabaogaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianchabaogaoEntity jianchabaogao = jianchabaogaoService.selectById(id);
		jianchabaogao = jianchabaogaoService.selectView(new EntityWrapper<JianchabaogaoEntity>().eq("id", id));
        return R.ok().put("data", jianchabaogao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianchabaogaoEntity jianchabaogao = jianchabaogaoService.selectById(id);
		jianchabaogao = jianchabaogaoService.selectView(new EntityWrapper<JianchabaogaoEntity>().eq("id", id));
        return R.ok().put("data", jianchabaogao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianchabaogaoEntity jianchabaogao, HttpServletRequest request){
    	jianchabaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianchabaogao);
        jianchabaogaoService.insert(jianchabaogao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianchabaogaoEntity jianchabaogao, HttpServletRequest request){
    	jianchabaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianchabaogao);
        jianchabaogaoService.insert(jianchabaogao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianchabaogaoEntity jianchabaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianchabaogao);
        jianchabaogaoService.updateById(jianchabaogao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianchabaogaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
