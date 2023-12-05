package com.egg.salud_webapp.entidades;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(iso = ISO.TIME)
    private LocalDateTime fechaHora;
    private boolean disponible;
    @ManyToOne
    private Profesional profesional;
    @ManyToOne
    private Paciente paciente;
    @Column(name = "duracion_minutos")
    private int duracionEnMinutos;

    public Turno() {
    }

    public Turno(Profesional profesional, LocalDateTime fechaHora, int duracionEnMinutos) {
        this.profesional = profesional;
        this.fechaHora = fechaHora;
        this.duracionEnMinutos = duracionEnMinutos;
        this.disponible = true;
    }

    public Turno(Paciente paciente) {
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}