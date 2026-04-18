package com.joaquim.modularpamishareadpreferences;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.joaquim.modularpamishareadpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        AnotacaoPreferencias preferencias = new AnotacaoPreferencias(this);

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(binding.getRoot(),"Clicou no botao", Snackbar.LENGTH_LONG).
                    setAnchorView(R.id.floatingActionButton).
                    setAction("Action", null).show();

                String textoRecuperado = binding.editTextText.getText().toString();

                if (textoRecuperado.isEmpty()){
                    Snackbar.make(binding.getRoot(), "Digite algo" , Snackbar.LENGTH_LONG).show();
                }else {
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(binding.getRoot(), "Anotacao Salva", Snackbar.LENGTH_LONG).show();
                }


            }


        });

    }
}