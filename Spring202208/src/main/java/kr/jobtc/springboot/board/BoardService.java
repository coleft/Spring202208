package kr.jobtc.springboot.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jobtc.springboot.mybatis.BoardMapper;

@Service
public class BoardService {	//crud를 다 처리할거라면 transaction을 걸어주고 dao를 따로 설정하겠다면 transaction은 필요 없다.
	@Autowired
	BoardMapper mapper;
	
	public List<BoardVo> select(String findStr) {
		List<BoardVo> list = mapper.select("1");
		return list;
	}
}





