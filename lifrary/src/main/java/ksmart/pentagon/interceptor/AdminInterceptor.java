package ksmart.pentagon.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);

		if (session != null) {

			String SAID = (String) session.getAttribute("SAID");
			// 사서 로그인된 경우 요청한 url로 이동
			if (SAID != null) {
				return true;
			}
			// 사서 로그인 안된 경우
			else {
				String PF = (String)session.getAttribute("PF");
				if(PF == null) { // PF가 null인 경우는 포트폴리오 보기버튼을 눌러 들어간것으로, PF가 세션에 없으므로 정상적으로 보여준다.
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('잘못된 접근입니다'); location.href='/admin/login';</script>");
					out.flush();
					return false;
				}else {
					session.setAttribute("SAID", "id006");
					session.setAttribute("SANAME", "한우리");
					session.setAttribute("SADIV", "관리자");
					session.setAttribute("LIBNUM", "000000");
					session.setAttribute("SALI", "O"); // library insert - 사서 등록
					session.setAttribute("SALC", "O"); // library carry - 수서
					session.setAttribute("SALBA", "O"); // library book admin - 대출, 반납, 예약
					session.setAttribute("SALS", "O"); // library stats - 통계
					session.setAttribute("SALBS", "O"); // library book stock - 장서 점검
					return true;
					
				}
				
			}
		}

		else {
			String PF = (String)session.getAttribute("PF");
			if(PF == null) { // PF가 null인 경우는 포트폴리오 보기버튼을 눌러 들어간것으로, PF가 세션에 없으므로 정상적으로 보여준다.
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('잘못된 접근입니다'); location.href='/';</script>");
				out.flush();
				return false;
			}else {
				session.setAttribute("SAID", "id006");
				session.setAttribute("SANAME", "한우리");
				session.setAttribute("SADIV", "관리자");
				session.setAttribute("LIBNUM", "000000");
				session.setAttribute("SALI", "O"); // library insert - 사서 등록
				session.setAttribute("SALC", "O"); // library carry - 수서
				session.setAttribute("SALBA", "O"); // library book admin - 대출, 반납, 예약
				session.setAttribute("SALS", "O"); // library stats - 통계
				session.setAttribute("SALBS", "O"); // library book stock - 장서 점검
				return true;
			}
			
				
			

		}
	}
}
