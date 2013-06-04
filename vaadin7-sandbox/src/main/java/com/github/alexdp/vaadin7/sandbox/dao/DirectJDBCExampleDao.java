package com.github.alexdp.vaadin7.sandbox.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.alexdp.vaadin7.sandbox.model.DirectJDBCExampleBean;

@Repository
public class DirectJDBCExampleDao {

	@Autowired
	private JdbcTemplate jdbcTemplateBanner;

	@Value("#{SQLQueries['DirectJDBCExampleDao.getBeanById']}")
	private String GET_BEAN_BY_ID_QUERY;

	@Value("#{SQLQueries['DirectJDBCExampleDao.getAllBeans']}")
	private String GET_ALL_BEANS_QUERY;

	@Value("#{SQLQueries['DirectJDBCExampleDao.insertBean']}")
	private String INSERT_BEAN_QUERY;

	private RowMapper<DirectJDBCExampleBean> aRowMapper = new RowMapper<DirectJDBCExampleBean>() {
		@Override
		public DirectJDBCExampleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DirectJDBCExampleBean bean = new DirectJDBCExampleBean();
			bean.setId(rs.getLong(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			return bean;
		}
	};

	public DirectJDBCExampleBean getBeanById(Long id) {
		return this.jdbcTemplateBanner.queryForObject(GET_BEAN_BY_ID_QUERY, aRowMapper, id);
	}

	public List<DirectJDBCExampleBean> getAllBeans() {
		return this.jdbcTemplateBanner.query(GET_ALL_BEANS_QUERY, new Object[] {}, aRowMapper);
	}

	public void insertBean(DirectJDBCExampleBean bean) {
		this.jdbcTemplateBanner.update(INSERT_BEAN_QUERY, bean.getFirstname(), bean.getLastname());
	}

}
