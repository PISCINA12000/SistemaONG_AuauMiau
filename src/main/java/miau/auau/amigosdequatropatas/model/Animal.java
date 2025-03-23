package miau.auau.amigosdequatropatas.model;

import jakarta.persistence.*;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cod;
    private String nome;
    private char sexo;
    private String raca;
    private int idade;
    private double peso;
    private boolean castrado;
    private boolean adotado;


    // tratar foto depois
    // Construtores
    public Animal(int cod, String nome, char sexo, String raca, int idade, double peso, boolean castrado,  boolean adotado) {
        this.cod = cod;
        this.nome = nome;
        this.sexo = sexo;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.castrado = castrado;
        this.adotado = adotado;

    }
    public Animal(){
        this(0,"",' ',"",0,0,false,false);
    }

    // Gets e Sets
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    // Métodos
    public List<Animal> getAnimal() {
        List<Animal> lista = new ArrayList<>();
        // retorna todos os animais chamando o banco de dados
        //lista = objetoBanco.getAnimal;
        return lista;
    }
}
