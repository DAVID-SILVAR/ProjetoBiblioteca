package Classes;

import java.util.ArrayList;


public class Cliente extends Pessoa {
    
    private int id;
    private String nome;
    private String dataNasc;
    private String sexo;
    private String cpf;
    private String fone;
    private ArrayList<Livro> livro;

    public Cliente(String nome, String dataNasc, String sexo, String cpf, String fone) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.cpf = cpf;
        this.fone = fone;
    }
    
     public Cliente() {
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }  
    
}