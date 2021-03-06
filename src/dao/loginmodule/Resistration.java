package dao.loginmodule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbcp.DBConnectionMgr;
import dto.UserInfo;

public class Resistration {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DBConnectionMgr pool;
	
	public Resistration(){
		try{
			pool = DBConnectionMgr.getInstance();
			con = pool.getConnection();
		}
		catch(Exception err){
			System.out.println("DBCP 인스턴스 참조 실패 : " + err);
		}
	}
	
	// 회원가입 등록, UserInfo는 dto 클래스
	public void regUser(UserInfo dto){
		String sql = "insert into userinfo(u_id, u_pw, u_name, u_nickname, u_phone, u_email, u_addr, u_postnumber, "
				+ "u_birth, u_gender, u_introduce, u_regdate, u_point, u_power, u_delete, u_question, u_answer, u_comment) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,sysdate,0,1000,'N',?,?,?)";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getU_id());
			pstmt.setString(2, dto.getU_pw());
			pstmt.setString(3, dto.getU_name());
			pstmt.setString(4, dto.getU_nickname());
			pstmt.setString(5, dto.getU_phone());
			pstmt.setString(6, dto.getU_email());
			pstmt.setString(7, dto.getU_addr());
			pstmt.setString(8, dto.getU_postnumber());
			pstmt.setString(9, dto.getU_birth());
			pstmt.setString(10, dto.getU_gender());
			pstmt.setString(11, dto.getU_introduce());
			//pstmt.setString(12, dto.getU_regdate());
			//pstmt.setString(13, dto.getU_point());
			//pstmt.setString(14, dto.getU_power());
			//pstmt.setString(15, dto.getU_delete());
			pstmt.setString(12, dto.getU_question());
			pstmt.setString(13, dto.getU_answer());
			pstmt.setString(14, dto.getU_comment());
			
			pstmt.executeUpdate();
		}
		catch(Exception err){
			System.out.println("regUser에서 오류");
			err.printStackTrace();
		}
		finally{
			pool.freeConnection(con, pstmt, rs);
		}
	}
	
	
	
	

}
