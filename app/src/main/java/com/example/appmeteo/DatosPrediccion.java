package com.example.appmeteo;

public class DatosPrediccion {


    private double temperatura;
    private String clima;
    private String lluvia;

    public DatosPrediccion( double temperatura, String clima, String lluvia) {

        this.temperatura = temperatura;
        this.clima = clima;
        this.lluvia = lluvia;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getLluvia() {
        return lluvia;
    }

    public void setLluvia(String lluvia) {
        this.lluvia = lluvia;
    }
}
