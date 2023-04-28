package classes;

import java.util.Calendar;

import java.util.Date;

import classes.Datas;

public class Pessoa {
    
        private String nome;
        private String sobrenome;
        private int idade;
        private double altura;
        private double peso;
        private double imc;
        private Datas dataNascimento;
        
        public Pessoa(String nome, String sobrenome, Datas dataNascimento, double altura, double peso) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.dataNascimento = dataNascimento ;
            this.altura = altura;
            this.peso = peso;
            this.imc = imc;
        }
        
        public Pessoa(String nome, String sobrenome, Calendar dataNascimento, double altura, double peso) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.dataNascimento = new Datas(dataNascimento.get(Calendar.DAY_OF_MONTH), 
                                            dataNascimento.get(Calendar.MONTH) + 1, 
                                            dataNascimento.get(Calendar.YEAR));
            this.altura = altura;
            this.peso = peso;
            this.imc = imc;
        }
    

    public void informaObesidade() {
        double imc = this.getImc();
        if (imc < 18.5) {
            System.out.println("A pessoa está abaixo do peso.");
        } 
        
        else if (imc >= 18.5 && imc < 25) {
            System.out.println("A pessoa está com peso normal.");
        } 
        
        else if (imc >= 25 && imc < 29.9) {
            System.out.println("A pessoa está com sobrepeso.");
        } 
        
        else if (imc >= 30 && imc < 34.9) {
            System.out.println("A pessoa está com obesidade grau I.");
        } 
        
        else if (imc >= 35 && imc < 39.9) {
            System.out.println("A pessoa está com obesidade grau II (severa).");
        } 
        
        else if (imc >= 40) {
            System.out.println("A pessoa está com obesidade grau III (mórbida).");
        }
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Datas getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Datas dataNascimento) {
        Calendar cal = Calendar.getInstance();
        cal.set(dataNascimento.getAno(), dataNascimento.getMes()-1, dataNascimento.getDia());
        this.dataNascimento = cal;
    }

    public double getImc() {
        return peso / (altura * altura);
    }

    
  
    

    public int calculaIdades () {
    
    Calendar hoje = Calendar.getInstance();
    
    Calendar nascimento = Calendar.getInstance();
    nascimento.set(dataNascimento.getAno(), dataNascimento.getMes()-1, dataNascimento.getDia());
    
    int idade = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
    if (hoje.get(Calendar.MONTH) < nascimento.get(Calendar.MONTH)) {
        idade--;
    } else if (hoje.get(Calendar.MONTH) == nascimento.get(Calendar.MONTH) &&
               hoje.get(Calendar.DAY_OF_MONTH) < nascimento.get(Calendar.DAY_OF_MONTH)) {
        idade--;
    }
    return idade;
    }
}



