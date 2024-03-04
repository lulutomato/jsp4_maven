package day4.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.CustomerDto;
import day4.mybatis.dto.ProductDto;
import mybatis.SqlSessionBean;

public class MybatisCustomerDao {
	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
	
	public List<CustomerDto> selectAll(){
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerDto> list = sqlSession.selectList("tblcustomer.selectAll");
		sqlSession.close();
		return list;
	}
	public int insert(CustomerDto dto) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblcustomer.insert",dto);
		sqlSession.commit();
		sqlSession.close();
		return result;		
	}
	public int update(CustomerDto dto) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblcustomer.update",dto);
		sqlSession.commit();
		sqlSession.close();
		return result;		
	}
	public int delete(String customerId) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.delete("tblcustomer.delete",customerId);
		sqlSession.commit();
		sqlSession.close();
		return result;
		
		
	}
	public CustomerDto getCustomer(String custom_id) {
		SqlSession sqlSession = sessionFactory.openSession();
		CustomerDto dto = sqlSession.selectOne("tblcustomer.getCustomer",custom_id);
		sqlSession.close();
		return dto;
	}
	
	
	
	
}
