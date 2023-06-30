package ar.edu.unlam.dominio;

public class Usuario {
	private String usuario;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private int edad;
	private boolean logueado;
	private boolean bloqueado;
	
	public Usuario(String usuario, String contrasenia, String nombre, String apellido, int edad) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	public boolean laContraseniaEsValida(String contrasenia) {
		boolean contraseniaValida = false;
		int cantidadDeNumeros = 0;
		int cantidadDeMayusculas = 0;
		int cantidadDeMinusculas = 0;
		int cantidadDeCaracteresEspeciales = 0;
		char[] contraseniaEnArray = contrasenia.toCharArray();
		if(contrasenia.length() >= 8) {
			for(int i = 0; i < contraseniaEnArray.length; i++) {
				if(Character.isDigit(contraseniaEnArray[i])) {
					cantidadDeNumeros++;
				}if(Character.isUpperCase(contraseniaEnArray[i])) {
					cantidadDeMayusculas++;
				}if(Character.isLowerCase(contraseniaEnArray[i])) {
					cantidadDeMinusculas++;
				}if(!Character.isLetterOrDigit(contraseniaEnArray[i])) {
					cantidadDeCaracteresEspeciales++;
				}
			}
			if(cantidadDeNumeros >= 1 && cantidadDeMayusculas >= 1 && cantidadDeMinusculas >= 1 && cantidadDeCaracteresEspeciales >= 1) {
				contraseniaValida = true;
			}
			
		}
		return contraseniaValida;
		//a. Tiene una longitud de al menos 8 caracteres.
		//b. Contiene al menos un carácter numérico.
		//c. Contiene al menos una mayúscula.
		//d. Contiene al menos una minúscula.
		//e. Contiene al menos un carácter especial. 
		
	}
	
	public boolean cambiarContrasenia(String contraseniaVieja, String contraseniaNueva) {
		boolean contraseniaCambiada = false;
		if(this.contrasenia.equals(contraseniaVieja) && this.laContraseniaEsValida(contraseniaNueva) ) {
			this.contrasenia = contraseniaNueva;
			contraseniaCambiada = true;
		}
		//a. La nueva contraseña debe ser válida.
		//b. La nueva contraseña debe ser diferente a las últimas 5 contraseñas utilizadas.
		//c. El método devolverá true si la contraseña se pudo actualizar o false en caso contrario.
		return contraseniaCambiada;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", apellido="
				+ apellido + ", edad=" + edad + ", logueado=" + logueado + ", bloqueado=" + bloqueado + "]";
	}
	
	
	
	
}

