package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cadastro extends AppCompatActivity {
    private TextView nome;
    private TextView email;
    private TextView senha;
    public static List<Usuario> listaUsuarios;
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imgFoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        nome = findViewById(R.id.txtNome);
        email = findViewById(R.id.txtEmail);
        senha = findViewById(R.id.txtSenha);
        listaUsuarios = new ArrayList<>();
        imgFoto = findViewById(R.id.imgFoto);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imgFoto.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void selecionarFoto(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), PICK_IMAGE_REQUEST);
    }



    public void entrarLogin(View view){
        Intent entrar = new Intent(Cadastro.this,MainActivity.class);
        startActivity(entrar);
    }
    public void cadastrarUsuario(View view){
        String nomeUsuario = nome.getText().toString();
        String emailUsuario = email.getText().toString();
        String senhaUsuario = senha.getText().toString();
        if (!nomeUsuario.isEmpty() && !emailUsuario.isEmpty() && !senhaUsuario.isEmpty()) {

            FileOutputStream fos = null;
            try {
                fos = openFileOutput("foto.jpg", Context.MODE_PRIVATE);
                Bitmap bitmap = ((BitmapDrawable) imgFoto.getDrawable()).getBitmap();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Usuario novoUsuario = new Usuario();
            Bitmap fotoUsuario = ((BitmapDrawable) imgFoto.getDrawable()).getBitmap();
            novoUsuario.criarUsuario(nomeUsuario,emailUsuario,senhaUsuario,fotoUsuario);
            listaUsuarios.add(novoUsuario);
        }else {
            Toast.makeText(Cadastro.this, "Preenchimento incorreto, verifique os campos!", Toast.LENGTH_SHORT).show();
        }
    }




}