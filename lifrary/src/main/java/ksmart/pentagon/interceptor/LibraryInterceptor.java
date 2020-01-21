package ksmart.pentagon.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LibraryInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);
		String uri = request.getRequestURI();
		if (session != null) {
			if (("/lifrary/myUserDetail").equals(uri) || ("/lifrary/myPointList").equals(uri)
					|| ("/lifrary/myLendList").equals(uri) || ("/lifrary/myHoldList").equals(uri)
					|| ("/lifrary/myCalender").equals(uri) || ("/lifrary/myBookReportSearchList").equals(uri)
					|| ("/lifrary/myStudyList").equals(uri) || ("/lifrary/programApplyList").equals(uri)
					|| ("/lifrary/myReadingRoomReserveList").equals(uri)
					|| ("/lifrary/myStudyRoomReserveList").equals(uri)
					|| ("/lifrary/myLectureRoomReserveList").equals(uri)
					|| ("/lifrary/myLockerReserveList").equals(uri)) {
				String SID = (String) session.getAttribute("SID");
				// 로그인 한 경우
				if (SID != null) {
					return true;
				}
				// 로그인 안한 경우
				else {
					String PF = (String)session.getAttribute("PF");
					if(PF == null) { // PF가 null인 경우는 포트폴리오 보기버튼을 눌러 들어간것으로, PF가 세션에 없으므로 정상적으로 보여준다.
						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('로그인 후 이용가능 합니다'); location.href='/lifrary/login';</script>");
						out.flush();
						return false;
						
					} else {
						session.setAttribute("SID", "id003");
						session.setAttribute("SNAME", "최지혜");
						session.setAttribute("SDIV", "회원");
						return true;
						
					}


				}
			} else {
				return true;
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
			}else { // PF가 null이 아닌경우, 포트폴리오에서 이미지를 클릭하여 들어간것으로, PF가 세션에 있으므로, 아이디를 등록해준다.
				session.setAttribute("SID", "id003");
				session.setAttribute("SNAME", "최지혜");
				session.setAttribute("SDIV", "회원");
				return true;
			}
				
				
		}
	}
}
