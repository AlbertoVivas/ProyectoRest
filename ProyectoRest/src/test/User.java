/**
 * 
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jdbc.EmpleadoDTO;

/**
 * @author Alberto Vivas
 *
 * 
 */
@Path ("/User")
public class User {
	
	
	@GET
	@Path ("/Get/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUser(@PathParam ("id") String id) throws ClassNotFoundException, SQLException{
		String respuesta = "";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String conexion = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "HR";
		String password = "a123456";
		Connection conn;
		Class.forName(driver);
		conn = DriverManager.getConnection(conexion, user, password);
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?");
		ps.setString(1, id);
		ResultSet rset = ps.executeQuery();
		
		while (rset.next()) {
			String employee_id = rset.getString(1);
			String first_name = rset.getString(2);
			String last_name = rset.getString(3);
			String email = rset.getString(4);
			String phone_number = rset.getString(5);
			String hire_date = rset.getString(6);
			String job_id = rset.getString(7);
			int salary = rset.getInt(8);
			String commision_pct = rset.getString(9);
			String mannager_id = rset.getString(10);
			String department_id = rset.getString(11);
			respuesta= new EmpleadoDTO(employee_id, first_name, last_name,	email, phone_number, hire_date, job_id,	salary, commision_pct, mannager_id,	department_id).toString();
		}
		conn.commit();
		
		conn.close();
		ps.close();
		rset.close();
		
		return respuesta;
	}

}
