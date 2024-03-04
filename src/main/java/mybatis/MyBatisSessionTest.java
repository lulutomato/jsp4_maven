package mybatis;

import java.util.List;

import day4.mybatis.dao.MybatisBuyDao;
import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CustomerDto;
import day4.mybatis.dto.ProductDto;


public class MyBatisSessionTest {

	public static void main(String[] args) {
		testProduct();
		testCustomer();
		testBuy();
		
		
	}
	
	public static void testProduct() {
		MybatisProductDao dao = new MybatisProductDao();
		System.out.println("dao 객체 : " + dao);
		
		System.out.println("===== selectAll 테스트 =====");
		List<ProductDto> list = dao.selectAll();
		System.out.println(list);
		
		System.out.println("===== selectbycategory 테스트 =====");
		List<ProductDto> categorylist = dao.selectByCategory("C1");
		System.out.println(categorylist);
		
		System.out.println("===== selectbypname 테스트 =====");
		 ProductDto dto = dao.selectByPname("사과");
		System.out.println(dto);
		
		System.out.println("===== delete 테스트 =====");
		
	}		
	
	
	
		public static void testCustomer() {
			MybatisCustomerDao dao = new MybatisCustomerDao();
			System.out.println("dao 객체 : " + dao);
			
			System.out.println("===== selectAll 테스트 =====");
			List<CustomerDto> list = dao.selectAll();
			System.out.println(list);
	}
	
	
	
	
	public static void testBuy() {
		MybatisBuyDao dao = new MybatisBuyDao();
		System.out.println("dao 객체:" + dao);
		
		System.out.println("===== insert 테스트 =====");
		int result = dao.insert(new BuyDto(0,"mina012","CJBAb12g", 3, null));
		System.out.println("반영된 행 개수 : " + result);
		
		System.out.println("===== selectAll 테스트 =====");
		List<BuyDto> list = dao.selectAll();
		System.out.println(list);
		
		System.out.println("=====selectCustomerBuyList 테스트 =====");
		List<BuyDto> list2 = dao.selectCustomerBuyList("mina012");
		System.out.println(list2);
}
}
