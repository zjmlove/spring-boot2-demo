package com.demo.springboot.service.impl;


import com.demo.springboot.domain.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.springboot.domain.Demo;
import com.demo.springboot.mapper.DemoMapper;
import com.demo.springboot.service.DemoService;


@Service(DemoServiceImpl.SERVICE_NAME)
public class DemoServiceImpl implements DemoService {
	public static final String SERVICE_NAME = "demoService";

	@Autowired
	private DemoMapper demoMapper;

	@Override
	public Demo getDemoById(Long id) {
		return demoMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateDemo(Demo demo) {
		demoMapper.updateByPrimaryKeySelective(demo);
	}

	@Override
	public void removeDemo(Demo demo) {
		demoMapper.deleteByPrimaryKey(demo.getId());
	}

	@Override
	public void insertDemo(Demo demo) {
		demoMapper.insertSelective(demo);
	}

	@Override
	public DemoRepository getDemoRepositoryById(Long demoId) {
		return demoMapper.selectDemoRepositoryByPrimaryKey(demoId);
	}
}
