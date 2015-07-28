package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */

/**
 * @author Alberto Vivas
 *
 * 
 */
public class CargaUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conexion = null;
		Statement st = null;
		ResultSet rs = null;
		PrintWriter out = null;
		
		try 
			{
			conexion = Pool.getConnection();
			st = conexion.createStatement();
			rs = st.executeQuery("SELECT NOMBRE, CLAVE FROM USERS");
			
			
			resp.setContentType("text/xml");
			resp.setCharacterEncoding("UTF-8");
			
			
			
			out = resp.getWriter();
			
			out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			
			out.println("<listausers>");
			while (rs.next())
			{
				System.out.println((rs.getString(1) + 	rs.getString(2)));
				out.println("<user>");
				out.println("<nombre>"+ rs.getString(1)+"</nombre>");
				out.println("<clave>"+rs.getString(2)+"</clave>");
				out.println("</user>");
			}
			out.println("</listausers>");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		finally {
			Pool.liberarRecursos(conexion, st, rs);
		}
	}

}
