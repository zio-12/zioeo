package a;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A
 */
@WebServlet("/A")
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Connection conn;
       private PreparedStatement pstmt;
       private ResultSet rs;
       {
		// TODO Auto-generated method stub

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		try{
	         String dbURL="jdbc:mariadb://localhost:3306/employees";
	         String dbID = "root";
	         String dbPassword="rhdwn";
	         Class.forName("org.mariadb.jdbc.Driver");
	         conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
	        
	         
	         String SQL = "SELECT * FROM EMPLOYEES";

	         
	         pstmt = conn.prepareStatement(SQL);
	         rs = pstmt.executeQuery(SQL);
	
	         System.out.println("지원님의 데이터가 입력되었습니다.");
	       
	         while(rs.next()) {
	     		String emp_no = rs.getString("emp_no");
	     		String birth_date = rs.getString("birth_date");
	     		String emp_name = rs.getString("emp_name");
	     		String gender = rs.getString("gender");
	     		String hire_date = rs.getString("hire_date");
	    	
	        		
	        		request.setAttribute("emp_no", emp_no);
	        		request.setAttribute("birth_date", birth_date);
	        		request.setAttribute("emp_name", emp_name);
	        		request.setAttribute("gender", gender);
	        		request.setAttribute("hire_date", hire_date);
	        	
	        		 RequestDispatcher dispatcher = request.getRequestDispatcher("qq.jsp");

	     	 		dispatcher.forward(request, response);
	     	 		
	     	 		System.out.println(emp_name);
	        		
	         }
	        
	         }
	         catch (SQLException e) {
	            System.out.println("데이터 입력 오류... 원인 :::" +e.getMessage());
	         } catch (ClassNotFoundException e) {
	            System.out.println("클래시를 찾을 수 없습니다."+e.getMessage());
	         } finally{
	            if(conn != null)
	               try { 
	                  conn.close();
	               } catch (SQLException e) {
	                  e.printStackTrace();
	               }
	            if(pstmt != null)
	               try {
	                  pstmt.close();
	               }catch (SQLException e){
	                  e.printStackTrace();
	               }
	            }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		  }
	   }