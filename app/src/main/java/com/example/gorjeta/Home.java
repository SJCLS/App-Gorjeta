package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Home extends AppCompatActivity {
    private SeekBar seekBarGorjetta;
    private TextView txtDigiteValor;
    private TextView txtGorjeta;
    private TextView txtTotal;
    private TextView txtPorcentagem;
    private ImageView imagemUsuario;
    private TextView nomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        seekBarGorjetta = findViewById(R.id.seekBarGorjeta);
        txtGorjeta = findViewById(R.id.txtGorjeta);
        txtDigiteValor = findViewById(R.id.txtInserirValor);
        txtTotal = findViewById(R.id.txtTotal);
        txtPorcentagem = findViewById(R.id.txtPorcentagem);
        seekBarGorjetta.setVisibility(View.INVISIBLE);
        imagemUsuario = findViewById(R.id.imageUsuario);
        nomeUsuario = findViewById(R.id.textNomeUsuario);




        txtDigiteValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               /* if (charSequence.toString().isEmpty()) {
                    seekBarGorjetta.setVisibility(View.GONE);
                } else {
                    seekBarGorjetta.setVisibility(View.VISIBLE);
                }*/
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    seekBarGorjetta.setVisibility(View.INVISIBLE);
                } else {
                    seekBarGorjetta.setVisibility(View.VISIBLE);
                }
            }
        });



        seekBarGorjetta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    txtPorcentagem.setText(i + "%");
                    double valor = Double.parseDouble(txtDigiteValor.getText().toString());
                    double gorjeta = (i / 100.0) * valor;
                    double total = gorjeta + valor;

                // Formata os valores da gorjeta e do total para exibir apenas duas casas decimais
                DecimalFormat df = new DecimalFormat("0.00");
                String gorjetaFormatada = "R$ " + df.format(gorjeta);
                String totalFormatado = "R$ " + df.format(total);

                txtGorjeta.setText(gorjetaFormatada);
                txtTotal.setText(totalFormatado);
                }


                @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}