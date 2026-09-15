package com.caiosoaresalbino.caio_soares_logincomshared;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nome, email, senha;
    Button novo, entrar;
    CheckBox box;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponents();

        preferences = getSharedPreferences("login", MODE_PRIVATE);

        String pNome = preferences.getString("Nome", "");
        String pEmail = preferences.getString("Email", "");
        String pSenha = preferences.getString("Senha", "");

        if (!pNome.isEmpty() && !pEmail.isEmpty() && !pSenha.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Fechar a tela de login se já estiver logado
        }

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarDados()) {
                    if (box.isChecked()) {
                        SharedPreferences.Editor dados = preferences.edit();
                        dados.putString("Nome", nome.getText().toString());
                        dados.putString("Email", email.getText().toString());
                        dados.putString("Senha", senha.getText().toString());
                        dados.apply();
                    }

                    Toast.makeText(MainActivity.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Limpar campos para "novo usuário" ou implementar cadastro
                nome.setText("");
                email.setText("");
                senha.setText("");
                box.setChecked(false);
                Toast.makeText(MainActivity.this, "Campos limpos para novo cadastro", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initComponents() {
        nome = findViewById(R.id.edt_nome);
        email = findViewById(R.id.edt_email);
        senha = findViewById(R.id.edt_senha);
        novo = findViewById(R.id.btn_novo);
        entrar = findViewById(R.id.btn_entrar);
        box = findViewById(R.id.chk_box);
    }

    private boolean validarDados() {
        boolean retorno = true;

        if (nome.getText().toString().isEmpty()) {
            nome.setError("Campo nome não pode ficar vazio");
            nome.requestFocus();
            retorno = false;
        } else if (email.getText().toString().isEmpty()) {
            email.setError("Campo de email não pode ficar vazio");
            email.requestFocus();
            retorno = false;
        } else if (senha.getText().toString().isEmpty()) {
            senha.setError("Campo de senha não pode ficar vazio");
            senha.requestFocus();
            retorno = false;
        }

        return retorno;
    }
}
