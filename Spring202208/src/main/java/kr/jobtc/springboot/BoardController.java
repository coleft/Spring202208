package kr.jobtc.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.jobtc.springboot.board.BoardService;
import kr.jobtc.springboot.board.BoardVo;

@RestController
public class BoardController {
	
	JdbcTemplate jdbcTemp;	//mybatis를 사용하게 되면 불필요
	
	@Autowired
	BoardService service;
	
	@Autowired
	public BoardController(JdbcTemplate temp) {
		this.jdbcTemp = temp;
	}
	
	@RequestMapping("/board/board_select")
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();
		List<BoardVo> list = service.select("1");
		
		mv.addObject("list", list);
		mv.setViewName("board/board_select");
		return mv;
	}
	
	
	
	
	
	
	@RequestMapping("/board/test")	//Mapper있으니까 바꿔줄게
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		List<String> subjects = null;
		
		try {
			Connection conn = jdbcTemp.getDataSource().getConnection();
			
			String sql = "select subject from board";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			subjects = new ArrayList<String>();
			while(rs.next()) {
				subjects.add(rs.getString("subject"));
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		mv.addObject("subjects", subjects);	//이게 MODEL입니다.
		mv.setViewName("board/board_select");	/*  WEB-INF/view/board/board_select.jsp  */	//이게 VIEW입니다.
		return mv;
		
	}
	
}
