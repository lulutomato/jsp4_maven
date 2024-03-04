package day7.api;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns =  {"/"},description = "모든 요청을 받는 서블릿")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);
	
	@Override
	public void init() throws ServletException {
		RequestControllerMapping.init();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getServletPath();
		String method = req.getMethod();
		logger.info("service 메소드: url -{},method -{}",url,method);
		
		RequestMap map = new RequestMap(url,method);
		logger.info("요청 key : {}",map);
		Controller controller = RequestControllerMapping.getController(map);
		
		logger.info("controller 객체 : {}",controller.getClass());
		controller.handle(req,resp);
	}
}
