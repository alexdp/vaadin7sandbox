package com.github.alexdp.vaadin7.sandbox.dao;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.alexdp.vaadin7.sandbox.model.DirectJDBCExampleBean;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class DirectJDBCExampleDaoTest extends TestCase {

	@Autowired
	private DirectJDBCExampleDao dao;

	@Test
	public void testGetAllBeans() {
		List<DirectJDBCExampleBean> allBeans = dao.getAllBeans();
		assertTrue(allBeans.size() > 0);
	}

}
