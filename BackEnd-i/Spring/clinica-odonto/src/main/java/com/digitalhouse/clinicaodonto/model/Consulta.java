package com.digitalhouse.clinicaodonto.model;

import java.util.Date;

public class Consulta {
    private Integer idConsulta;
    private Paciente paciente;
    private Dentista dentista;
    private Date dataConsulta;

    public Consulta() {
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "idConsulta=" + idConsulta +
                ", paciente=" + paciente +
                ", dentista=" + dentista +
                ", dataConsulta=" + dataConsulta +
                '}';
    }
}
