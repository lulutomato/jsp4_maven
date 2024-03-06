package day7.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.mybatis.dao.MybatisProductDao;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ApiProductDeleteController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String pcode = request.getParameter("pcode");
		//dao 실행에서 삭제하기
		MybatisProductDao dao = new MybatisProductDao();
		int result =0;
		//응답은 post 처리 참고하세요
		try {
			result = dao.delete(pcode);
			
		}catch (Exception e) {
			log.info(e.getMessage());
		}
		String jsonData = "{\"result\":"+result+"}";
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonData);
	}
}