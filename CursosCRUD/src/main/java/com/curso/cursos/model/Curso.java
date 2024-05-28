package com.curso.cursos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codCurso;
	private String nombre;
	private Integer duracion;
	private Double precio;
	
	public Curso() {
		
	}
	
	public Curso(Integer codCurso) {
		this.codCurso = codCurso;
	}

	public Curso(String nombre, Integer duracion, Double precio) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	public Curso(Integer codCurso, String nombre, Integer duracion, Double precio) {
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	public Integer getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(Integer codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(codCurso, other.codCurso);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Curso [codCurso=").append(codCurso).append(", nombre=").append(nombre).append(", duracion=")
				.append(duracion).append(", precio=").append(precio).append("]");
		return builder.toString();
	}
	
	
}
