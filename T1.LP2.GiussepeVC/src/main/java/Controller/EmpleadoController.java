package Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.Empleado;

public class EmpleadoController {

    // INSERTAR NUEVO EMPLEADO
	
	public String insertarEmpleado(String apellidos, String nombres, int edad, String sexo, double salario) {
		
		SessionFactory sessionFac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFac.openSession();
		
		try {
			Empleado empleado = new Empleado(apellidos, nombres, edad, sexo, salario);
			
			session.beginTransaction();
			session.save(empleado);
			
			session.getTransaction().commit();
			
			sessionFac.close();
			
			return "Empleado" + " "+ empleado.getNombres() + " " +"creado con exito";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "No se pudo registrar el empleado";
	}
	
	// ELIMINAR EMPLEADO SEGUN SU CODIGO
	
	public String eliminarEmpleado(int idEmp) {
		SessionFactory sessionFac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFac.openSession();
		
		try {
			
			session.beginTransaction();
			Empleado elegido = session.get(Empleado.class, idEmp);
			session.delete(elegido);
			
			session.getTransaction().commit();
			sessionFac.close();
			
			return "Empleado con el codigo" +" "+elegido.getIdEmpleado()+" "+ "fue eliminado con exito";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "No se encontro el empleado";
	}
	
	// ACTUALIZAR EMPLEADO
	
	public String actualizarEmpleado(int idEmp, int edad, double salario) {
		
		SessionFactory sessionFac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFac.openSession();
		
		try {
			session.beginTransaction();
			Empleado empActualizar = session.get(Empleado.class, idEmp);
		    
			empActualizar.setEdad(edad);
			empActualizar.setSalario(salario);
			
			session.update(empActualizar);
			
			session.getTransaction().commit();
			
			sessionFac.close();
			
			return "El empleado con el codigo" +" "+ idEmp + " fue actualizado";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "El empleado no existe";
	}
	
	
	// BUSCAR EMPLEADO
	
	public String leerEmpleado(int idEmpleado) {
		
		SessionFactory sessionFac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFac.openSession();
		
		try {
			session.beginTransaction();
			Empleado encontrado = session.get(Empleado.class, idEmpleado);
			session.getTransaction().commit();
			
			sessionFac.close();
			
			return encontrado.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "El empleado con el codigo " + idEmpleado +" no existe";
	}
	
	
}
