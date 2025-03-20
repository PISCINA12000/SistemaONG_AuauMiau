package miau.auau.amigosdequatropatas.entidades;

import java.io.RandomAccessFile;

public class Animal {
    private int cod;
    private String nome;
    private char sexo;
    private String raca;
    private int idade;
    private double peso;
    private boolean castrado;
    private RandomAccessFile foto;
    private boolean adotado;
    private String especie;

    // Construtores
    public Animal(int cod, String nome, char sexo, String raca, int idade, double peso, boolean castrado, RandomAccessFile foto, boolean adotado, String especie) {
        this.cod = cod;
        this.nome = nome;
        this.sexo = sexo;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.castrado = castrado;
        this.foto = foto;
        this.adotado = adotado;
        this.especie = especie;
    }
    public Animal(){
        this(0,"",' ',"",0,0,false,null,false,"");
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

    public RandomAccessFile getFoto() {
        return foto;
    }

    public void setFoto(RandomAccessFile foto) {
        this.foto = foto;
    }

    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
