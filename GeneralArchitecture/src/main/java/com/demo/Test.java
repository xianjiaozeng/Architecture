package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.utils.BaseDao;

@Controller
@RequestMapping("/mvc")
public class Test extends BaseDao{
	
	private static Logger logger = LoggerFactory.getLogger(Test.class);
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String DaoTest(HttpServletRequest request,HttpServletResponse response){
		
		logger.info("jdbcTemplate为空判断：{}",this.jdbcTemplate==null);
		logger.info("mongoTemplate为空判断：{}",this.redisTemplate==null);
		logger.info("redisTemplate为空判断：{}",this.mongoTemplate==null);
		logger.info("mybatisTemplate为空判断：{}",this.sqlSessionTemplate==null);
		
		return null;
	}
	
}
