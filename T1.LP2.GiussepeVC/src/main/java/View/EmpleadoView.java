package View;

import Controller.EmpleadoController;

public class EmpleadoView {

	public static void main(String[] args) {
		
     /*String empleado = new EmpleadoController().insertarEmpleado("Vargas Azuzena", "Yaret Mia", 21, "Femenino", 1000);
     System.out.println(empleado);
     
     
		String empleado = new EmpleadoController().eliminarEmpleado(3);
		System.out.println(empleado);
	 
		
		String empleado = new EmpleadoController().actualizarEmpleado(1, 27, 1400);
		System.out.println(empleado);
		
	   */
		
		String empleado = new EmpleadoController().leerEmpleado(4);
		System.out.println(empleado);
		
	}

}
