package day7.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ApiProductPostController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		InputStream inputStream = request.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8));
		StringBuffer sb = new StringBuffer();
		String line = null;
		
		while((line =br.readLine())!=null) {
			sb.append(line);
			log.info("line:{}",line);
		}
		ObjectMapper objMapper = new ObjectMapper();
		ProductDto dto = objMapper.readValue(sb.toString(),ProductDto.class);
		
		log.info("변환된 dto : ()",dto);
		int result = 0;
		try {
			MybatisProductDao dao = new MybatisProductDao();
			result = dao.insert(dto);
		}catch (Exception e) {
			log.info("dao insert 예외 : {}",e.getMessage());
		}
		//방법2는 직접 문자열 만드는 대신 Map 에 저장해서 변환할수도 있습니다.
		String msg = "상품등록이 완료되었습니다.";
		if(result==0) msg = "상품등록 오류입니다. 상품 중복확인하세요";
		
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().print(msg);
	}

}
