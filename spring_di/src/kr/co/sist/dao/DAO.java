package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.vo.EmpVO;

/**
 * 
 * @author ÀçÇö
 *
 */
public interface DAO {

	public int insertEmp(EmpVO emp_vo) throws SQLException;
	
	public List<EmpVO> selectEmp() throws SQLException;

}// interface
