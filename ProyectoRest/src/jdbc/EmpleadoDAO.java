/**
 * 
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;



import jdbc.Conexion;
import jdbc.InstruccionesSQL;




/**
 * @author Alberto Vivas
 *
 * 
 */
public class EmpleadoDAO{
	//recuperar Todos() List<Empleados>
	private ResultSet rset;
	
	public EmpleadoDTO obtenerEmpleadoPorID(int id) throws ClassNotFoundException, SQLException{
		EmpleadoDTO respuesta = null;
		Connection newconex =null;
		PreparedStatement ps = null;
		Savepoint sp = null;	
		
			try {
				newconex = Conexion.obtenerConexion();
				newconex.setAutoCommit(false);
				sp= newconex.setSavepoint();
				ps = newconex.prepareStatement(InstruccionesSQL.leerEmpleadoPorID());
				ps.setInt(1, id);
				rset=ps.executeQuery();
				
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
					respuesta= new EmpleadoDTO(employee_id, first_name, last_name,	email, phone_number, hire_date, job_id,	salary, commision_pct, mannager_id,	department_id);	
			}
				
				
				
				newconex.commit();
			} catch (Exception e) {
				newconex.rollback(sp);
				e.printStackTrace();
			} finally // libero los recursos
			{
				Conexion.LiberarRecursos(newconex,ps);
			}
		
		return respuesta;
	}
	
}
