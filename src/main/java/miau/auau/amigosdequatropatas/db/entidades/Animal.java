package miau.auau.amigosdequatropatas.db.entidades;
import miau.auau.amigosdequatropatas.db.dals.AnimalDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Animal {

    @Autowired
    private AnimalDAL animalDAL;

    private int codAnimal;

    private String nome;

    private String  sexo;

    private String raca;

    private int idade;

    private double peso;

    private String castrado;

    private String adotado;

    private String fileName;

    // tratar foto depois
    // Construtores
    public Animal(int codAnimal, String nome, String sexo, String raca, int idade, double peso, String castrado,  String adotado, String fileName) {
        this.codAnimal = codAnimal;
        this.nome = nome;
        this.sexo = sexo;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.castrado = castrado;
        this.adotado = adotado;
        this.fileName = fileName;

    }
    public Animal(){
        this(0,"","","",0,0,"","", "");
    }

    // Gets e Sets
    public int getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(int codAnimal) {
        this.codAnimal = codAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
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

    public String getCastrado() {
        return castrado;
    }

    public void setCastrado(String castrado) {
        this.castrado = castrado;
    }

    public String getAdotado() {
        return adotado;
    }

    public void setAdotado(String adotado) {
        this.adotado = adotado;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

   // metodos

    public boolean incluir(Animal animal)
    {
        return animalDAL.gravar(animal); // grava no banco
    }
    public boolean excluir(Animal animal)
    {
        return animalDAL.apagar(animal);
    }
    public Animal consultarID(int id)
    {
        return animalDAL.get(id);
    }
    public List<Animal> consultar(String filtro)
    {
        return animalDAL.get(filtro);
    }
    public boolean alterar(Animal animal)
    {
        System.out.println(animal.getCodAnimal());
        System.out.println(animal.getNome());
        System.out.println(animal.getSexo());
        System.out.println(animal.getRaca());
        System.out.println(animal.getIdade());
        System.out.println(animal.getPeso());
        System.out.println(animal.getCastrado());
        System.out.println(animal.getAdotado());
        System.out.println(animal.getFileName());

        return animalDAL.alterar(animal);
    }

}
