package com.github.alexdp.vaadin7.sandbox.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.alexdp.vaadin7.sandbox.dao.HibernateExampleDao;

@Service
public class HibernateExampleService {

	private static final String DEFAULT_GROUP_NAME = "Default server list";

	private Log log = LogFactory.getLog(HibernateExampleService.class);

	@Autowired
	private HibernateExampleDao dummyDao;



}
