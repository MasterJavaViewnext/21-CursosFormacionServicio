package com.curso.model;

import java.util.Objects;

public class CursoDTO{
	private Integer codCurso;
	private String nombre;
	private Integer duracion;
	private Double precio;
	
	public CursoDTO() {
		
	}
	
	public CursoDTO(Integer codCurso) {
		this.codCurso = codCurso;
	}

	public CursoDTO(String nombre, Integer duracion, Double precio) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	public CursoDTO(Integer codCurso, String nombre, Integer duracion, Double precio) {
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
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoDTO other = (CursoDTO) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Curso [codCurso=").append(codCurso).append(", nombre=").append(nombre).append(", duracion=")
				.append(duracion).append(", precio=").append(precio).append("]");
		return builder.toString();
	}
	
	
}
