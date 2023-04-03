package com.example.gorjeta;


import android.graphics.Bitmap;

public class Usuario {
    private String email;
    private String senha;
    private String nome;
    private Bitmap foto;

    public Usuario() {
    }

    public Usuario(String email, String senha, String nome, Bitmap foto) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.foto = foto;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
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

    public void criarUsuario(String nome, String email, String senha, Bitmap foto){
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setFoto(foto);
    }



}
