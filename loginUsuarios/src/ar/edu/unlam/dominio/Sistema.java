package ar.edu.unlam.dominio;

public class Sistema {
	private String nombreDelSistema;
	private Usuario[] usuarios;
	
	
	public Sistema(String nombreDelSistema, int cantidadMaximaDeUsuarios) {
		this.nombreDelSistema = nombreDelSistema;
		this.usuarios = new Usuario[cantidadMaximaDeUsuarios];
	}
	
//	Desarrolle un método en la clase Sistema que le permita incorporar un usuario a su lista de usuarios.
//	Dicho método devolverá true si el usuario se puede ingresar en el sistema o false en caso contrario (no
//	se puede ingresar un nombre de usuario que ya exista). 

	
	public boolean ingresarUsuario(Usuario nuevoUsuario) {
		int i = 0;
		boolean usuarioIngresado = false;
		while(!usuarioIngresado && i < usuarios.length) {
			if(usuarios[i] == null) {
				usuarios[i] = nuevoUsuario;
				usuarioIngresado = true;
				break;
			}else {
				i++;
			}
		}
		return usuarioIngresado;
	}
	
	public int calcularLaCantidadDeUsuariosLogueados() {
		int cantidadDeUsuariosLogueados = 0;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null && usuarios[i].isLogueado()) {
				cantidadDeUsuariosLogueados++;
				
			}
		}
		return cantidadDeUsuariosLogueados;
	}
	
	public int calcularLaCantidadDeUsuariosBloqueados() {
		int cantidadDeUsuariosBloqueados = 0;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null && usuarios[i].isBloqueado()) {
				cantidadDeUsuariosBloqueados++;
			}
		}
		return cantidadDeUsuariosBloqueados;
	}
	
	public int calcularEdadPromedio() {
		int suma = 0;
		int contadorUsuarios = 0;
		int promedio = 0;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null) {
				suma += usuarios[i].getEdad();
				contadorUsuarios++;
			}
		}
		promedio = suma / contadorUsuarios;
		return promedio;
	}
	
	public boolean loguearUsuario (String usuario, String contraseña) {
		boolean usuarioLogueado = false;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null && usuarios[i].getUsuario().equals(usuario) && usuarios[i].getContrasenia().equals(contraseña)) {
				usuarios[i].setLogueado(true);
				usuarioLogueado = true;
				break;
			}
		}
		return usuarioLogueado;
	}
	
	
	
	public Usuario buscarUsuario(String usuario) {
		Usuario usuarioEncontrado = null;
		for(int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null && usuarios[i].getUsuario().equals(usuario)) {
				usuarioEncontrado = usuarios[i];
				break;
			}
		}
		return usuarioEncontrado;
	}
}
