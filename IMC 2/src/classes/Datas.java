package classes;

import classes.Datas;

public class Datas implements Comparable<Datas> {

    private int dia;
    private int mes;
    private int ano;

    
    
    public Datas(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


public int compareTo(Datas outraData) {
    if (this.ano != outraData.getAno()) {
        return this.ano - outraData.getAno();
    } else if (this.mes != outraData.getMes()) {
        return this.mes - outraData.getMes();
    } else {
        return this.dia - outraData.getDia();
    }
}
}


