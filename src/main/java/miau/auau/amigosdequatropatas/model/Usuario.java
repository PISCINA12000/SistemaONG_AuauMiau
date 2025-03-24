package miau.auau.amigosdequatropatas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int codUsuario;

    private String nome;

    private String email;

    private String senha;

    private String telefone;

    private String cpf;

    private String privilegio;

    private char sexo;

    private String cep;

    private String rua;

    private String bairro;

    private String numero;

    // Construtores
    public Usuario(int cod, String nome, String email, String senha, String telefone, String cpf, String privilegio, char sexo, String cep, String rua, String bairro, String numero) {
        this.codUsuario = cod;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cpf = cpf;
        this.privilegio = privilegio;
        this.sexo = sexo;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public Usuario() {
        this(0, "", "", "", "", "", "", ' ', "", "", "", "");
    }

    // Gets e Sets
    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCod(int cod) {
        this.codUsuario = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
