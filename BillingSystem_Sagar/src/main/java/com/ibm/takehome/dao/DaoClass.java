package com.ibm.takehome.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.takehome.bean.Products;

@Repository
public class DaoClass {
	DataSource dataSource;

	NamedParameterJdbcTemplate namedTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		
		namedTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public boolean checkId(int productId) {
		String name=null;
		String qryFetch = "select productName from products where productId = :id";
		
		
		try {
			name=namedTemplate.queryForObject(qryFetch, new MapSqlParameterSource("id", productId), String.class);
			if(name.equals(null))
				return false;
			else
				return true;
		}
		catch(EmptyResultDataAccessException e)
		{
			System.out.println("Item does not exist");
		}
		return false;
	}

	public int getPrice(int productId) {
		String qryFetch = "select productPrice from products where productId = :id";
		
		//Execute the query
		return namedTemplate.queryForObject(qryFetch, new MapSqlParameterSource("id", productId), Integer.class);
	}

	public Boolean delFromDb(int productId, int quantity) {
		String qry = "select productQuantity from products where productId = :id";
		int quant = namedTemplate.queryForObject(qry, new MapSqlParameterSource("id", productId), Integer.class);
		if(quant<quantity)
		{
			return false;
		}
		else
		{
			quant=quant-quantity;
			qry = "update products set productQuantity = :quant where productId = :id";
			namedTemplate.update(qry, new MapSqlParameterSource("quant", quant).addValue("id", productId));
			return true;
		}
		
	}

	public Products fetchInfo(int productId, int quantity) {
		
		String qry = "select * from products where productId = :id";
		
		return namedTemplate.queryForObject(qry, new MapSqlParameterSource("id", productId), new UserMapper());
	}
	class UserMapper implements RowMapper<Products>{
		Products prod;
		public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
			prod = new Products();
			
			prod.setProductId(rs.getInt("productId"));
			prod.setProductName(rs.getString("productName"));
			prod.setProductPrice(rs.getInt("productPrice"));
			
			return prod;
		}

}
}