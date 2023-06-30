package ar.edu.unlam.interfaz;
import ar.edu.unlam.dominio.*;
import java.util.Scanner;

public class PruebaSistema {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre del sistema");
		String nombreSistema = scanner.next();
		Usuario [] usuarios = new Usuario[30];
	
		System.out.println("Ingrese la cantidad de usuarios del sistema");
		int cantidadDeUsuarios = scanner.nextInt();
		
		Sistema sistema = new Sistema(nombreSistema, cantidadDeUsuarios);
//		Usuario usuario1 = new Usuario("Ronki", "Ronki123@", "Juan", "Ronquillo", 20);
//		
//		usuarios[0] = usuario1;
//		
//		System.out.println(sistema.ingresarUsuario(usuarios[0]));
//		System.out.println("Login " + sistema.loguearUsuario("Ronki", "Ronki123@"));
//		System.out.println(usuarios[0].toString());
//		
//		System.out.println("Validar contrasenia: " + usuarios[0].laContraseniaEsValida("Ronki123@"));
		
//		10. Desarrolle un menú para los administradores del sistema que permita:
//		a. Registrar nuevos usuarios en el Sistema
//		b. Ver las estadísticas del sistema (Cantidad de usuarios logueados, bloqueados, porcentaje de
//		usuarios logueados y edad promedio de los usuarios)
//		c. Probar el login. Esto es, como administrador se verifica el acceso al sistema de un usuario
//		determinado. Al salir, el usuario utilizado quedará como logueado para poder evaluar las
//		estadísticas. 
		
		int opcion = 0;
		Menu opcionMenu = Menu.LOGIN_USUARIO;
		
		while(opcionMenu != Menu.SALIR) {
			do {
					System.out.println("Que desea hacer?");
					for(int i = 0; i < Menu.values().length; i++) {
						System.out.println("Ingrese: " + (i + 1) + " para " + Menu.values()[i]);
					}
					
					opcion = scanner.nextInt();
					
					if(opcion > 0 && opcion <= Menu.values().length) {
						opcionMenu = Menu.values()[opcion - 1];
					} else {
						System.out.println("Opcion incorrecta");
					} 
			}while (opcion <= 0 || opcion > Menu.values().length);
					
					switch (opcionMenu) {
					case REGISTRAR_USUARIO:
						Usuario nuevoUsuario = null;

						System.out.println("Ingrese el nombre de usuario");
						String nombreUsuario = scanner.next();
						
						System.out.println("Ingrese la contrasenia");
						String contrasenia = scanner.next();
						
						System.out.println("Ingrese el nombre");
						String nombre = scanner.next();
						
						System.out.println("Ingrese el apellido");
						String apellido = scanner.next();
						
						System.out.println("Ingrese la edad");
						int edad = scanner.nextInt();
						
						nuevoUsuario = new Usuario(nombreUsuario, contrasenia, nombre, apellido, edad);
						
						if(!nuevoUsuario.laContraseniaEsValida(contrasenia)) {
							do {
								System.out.println("Contrasenia invalida");
								System.out.println("Ingrese nuevamente la contrasenia");
								 contrasenia = scanner.next();
								 nuevoUsuario.setContrasenia(contrasenia);
							} while(!nuevoUsuario.laContraseniaEsValida(contrasenia));
							
						}else {
							int i = 0;
							boolean usuarioAgregado = false;
							while(!usuarioAgregado && i < usuarios.length) {
								
								usuarios[i]= nuevoUsuario;
								if(sistema.ingresarUsuario(usuarios[i])) {
									sistema.ingresarUsuario(usuarios[i]);
									usuarioAgregado = true;
									break;
								}else {
									System.out.println("Error al ingresar el usuario");
									i++;
									break;
								}
							}
							
							System.out.println("Usuario creado exitosamente");
						}
						break;
						
					case VER_ESTADISTICAS:
						if(usuarios[0] != null) {
							System.out.println("La edad promedio de los usuarios es de: " + sistema.calcularEdadPromedio());
							System.out.println("La cantidad de usuarios bloqueados es de: " + sistema.calcularLaCantidadDeUsuariosBloqueados());
							System.out.println("La cantidad de usuarios logeados es de: " + sistema.calcularLaCantidadDeUsuariosLogueados());
							
						}else {
							System.out.println("Aun no hay usuarios en el sistema");
						}
						break;
					
					case LOGIN_USUARIO:
						if(usuarios[0] != null) {
							for(int i = 0; i < usuarios.length; i++) {
								System.out.println("Ingrese el nombre de usuario");
								String nombreDeUsuario = scanner.next();
								
								System.out.println("Ingrese la contrasenia del usuario");
								String contraseniaUsuario = scanner.next();
								
								if(usuarios[i] != null && usuarios[i].getUsuario().equalsIgnoreCase(nombreDeUsuario) && usuarios[i].getContrasenia().equals(contraseniaUsuario)) {
									if(sistema.loguearUsuario(nombreDeUsuario, contraseniaUsuario)) {
										sistema.loguearUsuario(nombreDeUsuario, contraseniaUsuario);
										System.out.println("Usuario logeado exitosamente");
										break;
									}else {
										System.out.println("Error para logear el usuario");
										break;
									}
								}
							}
						}else {
							System.out.println("Aun no hay usuarios");
						}
							
						break;
						
					case CAMBIAR_CONTRASENIA:
						if(usuarios[0] != null) {
							int i = 0;
							boolean contraseniaCambiada = false;
							do {
								System.out.println("Ingrese su contraseniaa vieja");
								String contraseniaVieja = scanner.next();
								
								System.out.println("Ingrese la nueva contrasenia");
								String contraseniaNueva = scanner.next();
								
								if(usuarios[i] != null && usuarios[i].cambiarContrasenia(contraseniaVieja, contraseniaNueva)) {
									usuarios[i].cambiarContrasenia(contraseniaVieja, contraseniaNueva);
									System.out.println("Contrasenia cambiada exitosamente");
									contraseniaCambiada = true;
									break;
								}else if(!usuarios[i].cambiarContrasenia(contraseniaVieja, contraseniaNueva)){
									System.out.println("Error cambiando la contrasenia");
								}
								else {
									i++;
								}
								
								
							}while(!contraseniaCambiada && i < usuarios.length);
							
							
							
						}
						break;
					
					case SALIR:
						System.out.println("Hasta pronto");
						break;
					}
		}		
	}

}
