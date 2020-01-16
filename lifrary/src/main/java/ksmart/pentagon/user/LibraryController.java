package ksmart.pentagon.user;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.pentagon.vo.StudyCate;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserAuthorityHistory;
import ksmart.pentagon.vo.UserLevelHistory;

/*
 * @file   LibraryController.java
 * @name   library controller 
 * @brief  도서관 관련 매핑된 경로로 이동
 * @author 김상협 
 */

/*
 * @file   LibraryController.java
 * @name   library controller 
 * @brief  도서관 회원가입
 * @author 한우리
 */

@Controller
public class LibraryController {
	@Autowired
	private LibraryService libraryService;

	/**
	 * 도서관 로그인 페이지로 진입
	 * 
	 * @return libraryLogin페이지
	 * @author 김상협
	 * @date 19/12/05
	 */
	@GetMapping("/lifrary/login")
	public String login() {

		return "librarypage/user/login";
	}

	/**
	 * 로그인 처리후 인덱스로 이동
	 * 
	 * @param uId
	 * @param uPw
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping("/lifrary/login")
	public String login(@RequestParam(value = "uId") String uId, @RequestParam(value = "uPw") String uPw,
			HttpSession session, Model model) {

		String libNum = (String) session.getAttribute("LIBNUM");

		Map<String, Object> map = libraryService.loginCheck(uId, uPw, libNum);
		User user = (User) map.get("user");
		String result = (String) map.get("result");

		if (!result.equals("로그인 성공")) {
			// 경고창 출력을 위해 result보내주기
			model.addAttribute("result", result);
			return "librarypage/user/login";
		}

		session.setAttribute("SID", user.getuId());
		session.setAttribute("SNAME", user.getuName());
		session.setAttribute("SDIV", user.getuDivision());

		if (session.getAttribute("LIBNUM") == "000000") {
			return "redirect:/pentagon/index";
		} else if (session.getAttribute("LIBNUM") == "111111") {
			return "redirect:/square/index";
		} else {
			return "redirect:/";
		}
	}

	/**
	 * 로그아웃으로 세션 제거작업. 도서관 코드는 제거되면 안되므로 로그인시 셋팅했던 정보만 remove해준다.
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/lifrary/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("SID");
		session.removeAttribute("SNAME");
		session.removeAttribute("SDIV");
		session.getAttribute("LIBNUM");

		if (session.getAttribute("LIBNUM") == "000000") {
			return "redirect:/pentagon/index";
		} else if (session.getAttribute("LIBNUM") == "111111") {
			return "redirect:/square/index";
		} else {
			return "redirect:/";
		}
	}

	/***********************************************************************/

	/***
	 * 도서관페이지 회원가입 폼
	 * 
	 * @return
	 * @author 한우리
	 */
	// 회원가입 등록
	@GetMapping("/lifrary/userInsert")
	public String userInsert() {
		return "/librarypage/user/userInsert";
	}

	// 회원가입 등록
	// 4개 테이블 동시 등록
	@PostMapping("/lifrary/userInsert")
	public String userInsert(HttpSession session, User user, UserLevelHistory userLevelHistory,
			UserAuthorityHistory userAuthorityHistory, StudyCate studyCate) {

		libraryService.userInsertUser(user);
		libraryService.userInsertUserLevelHistory(userLevelHistory);
		libraryService.userInsertUserAuthorityHistory(userAuthorityHistory);
		libraryService.userInsertStudyCate(studyCate);

		return "redirect:/pentagon/index";
	}

	/***
	 * 도서관페이지 내정보 상세보기
	 * 
	 * @return
	 * @author 한우리
	 */
	// 도서관페이지-마이페이지 내정보 상세보기
	@GetMapping("/lifrary/myUserDetail")
	public String myUserDetail(Model model, HttpSession session) {

		String getSID = (String) session.getAttribute("SID");// 세션에서 회원ID
		String getSAID = (String) session.getAttribute("SAID");
		String libNum = (String) session.getAttribute("LIBNUM"); // 세션에서 도서관코드

		model.addAttribute("myUserDetail", libraryService.myUserDetail(getSID, libNum));
		return "/librarypage/user/myUserDetail";
	}

	// 도서관페이지 - 마이페이지 내정보 수정하기
	@GetMapping("/lifrary/myUserUpdate")
	public String getMyUserUpdate(Model model, HttpSession session) {

		String getSID = (String) session.getAttribute("SID");
		String getSAID = (String) session.getAttribute("SAID");
		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("myUserUpdate", libraryService.getMyUserUpdate(getSID, libNum));

		return "/librarypage/user/myUserUpdate";

	}

	// 사서 자신 정보 수정
	@PostMapping("/lifrary/myUserUpdate")
	public String myUserUpdate(User user) {

		libraryService.myUserUpdate(user);
		return "redirect:/lifrary/myUserDetail";
	}

	// 회원 탈퇴 하는 페이지
	@GetMapping("/lifrary/myUserDelete")
	public String myUserDelete() {
		return "/librarypage/user/myUserDelete";
	}

	// userDelete 삭제 결과값 가져오는 ajax - 회원탈퇴
	// 컨트롤러를 통해 보내고있는 응답의 유형을 나타 내기 위해 produce를 사용
	@RequestMapping(value = "/userDelete", produces = "text/plain")
	public @ResponseBody String userDelete(Model model, @RequestParam(value = "SID", required = false) String SID,
			@RequestParam(value = "uPw", required = false) String uPw, HttpSession session) {
		String libNum = (String) session.getAttribute("LIBNUM"); // 도서관코드
		String result = libraryService.deleteUser(SID, uPw, libNum);

		// 세션 종료
		if (result.equals("삭제")) {
			session.invalidate();
		}

		return result;
	}

	// 아이디,비번 찾기
	@GetMapping("/lifrary/userFindIdPw")
	public String userFindIdPw() {

		return "/librarypage/user/userFindIdPw";

	}

}
