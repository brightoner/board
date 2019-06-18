package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.IUserService;
import kr.or.ddit.board.service.UserService;
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	
	private IUserService userService;
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
		boardService = new BoardService();
	}
       
  //사용자 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UserVo SESSION_USER = (UserVo) request.getSession().getAttribute("USER_INFO");
		if(SESSION_USER != null){
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("login/login.jsp").forward(request, response);
		}
	}

	
	//로그인 요청처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String encyptPassword = KISA_SHA256.encrypt(password);
		
		UserVo userVo = userService.getUser(userId);
		List<BoardVo> boardList = boardService.allBoardList();
		
		
		if(userVo != null && encyptPassword.equals(userVo.getPass())){
//		if(userVo != null && password.equals(userVo.getPass())){
			
			
			HttpSession session = request.getSession();
			session.setAttribute("USER_INFO", userVo);
			
			for(int  i = 0; i < boardList.size(); i++){
				logger.debug("boardList : {}", boardList.get(i));
			}
			ServletContext sct = request.getServletContext();
			sct.setAttribute("boardList", boardList);
			
			request.getSession().setAttribute("USER_INFO", userVo);
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			
			
		}else{
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			
		}
		
		
	}

}








