package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView email;
    private TextView senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.txtEmail);
        senha = findViewById(R.id.txtSenha);
    }
    public boolean verificarUsuario(String email, String senha) {
        if (Cadastro.listaUsuarios != null){
            for (Usuario usuario : Cadastro.listaUsuarios) {
                if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                    return true;
                }
            }
       } return false;
    }
    public void entrarHome(View view) {
        String emailUsuario = email.getText().toString();
        String senhaUsuario = senha.getText().toString();
        if (!emailUsuario.isEmpty() && !senhaUsuario.isEmpty()) {
            if (verificarUsuario(emailUsuario, senhaUsuario)) {
                // usuário válido, abrir tela principal
                Intent entrar = new Intent(MainActivity.this, Home.class);
                startActivity(entrar);
            }else{
                Toast.makeText(MainActivity.this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        } else {
            // usuário inválido, exibir mensagem de erro
            Toast.makeText(MainActivity.this, "Preenchimento incorreto, verifique os campos!", Toast.LENGTH_SHORT).show();
        }
    }
    public void entrarCadastro(View view){
        Intent entrar = new Intent(MainActivity.this,Cadastro.class);
        startActivity(entrar);
    }
}