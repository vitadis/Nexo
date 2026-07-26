package com.example.nexoapp; // Cambia el paquete si el tuyo es diferente

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // Declaración de los componentes del layout
    private EditText etCorreo;
    private EditText etContrasena;
    private CheckBox cbRecordar;
    private Button btnIniciarSesion;
    private TextView tvOlvideContrasena;
    private TextView tvNoTengoCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Carga el layout activity_login.xml
        setContentView(R.layout.activity_login);

        // Relaciona las variables Java con los componentes XML
        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        cbRecordar = findViewById(R.id.cbRecordar);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        tvOlvideContrasena = findViewById(R.id.tvOlvideContrasena);
        tvNoTengoCuenta = findViewById(R.id.tvNoTengoCuenta);

        // Acción al pulsar el botón de iniciar sesión
        btnIniciarSesion.setOnClickListener(v -> {

            // Obtener el texto introducido por el usuario
            String correo = etCorreo.getText().toString().trim();
            String contrasena = etContrasena.getText().toString().trim();

            // Comprobar que los campos no estén vacíos
            if (correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(LoginActivity.this,
                        "Debes completar todos los campos",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // Credenciales de prueba
            if (correo.equals("admin@gmail.com") &&
                    contrasena.equals("1234")) {

                // Si el usuario marcó "Recordar contraseña"
                if (cbRecordar.isChecked()) {
                    Toast.makeText(LoginActivity.this,
                            "Sesión recordada",
                            Toast.LENGTH_SHORT).show();
                }

                // Ir a MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                // Cerrar LoginActivity
                finish();

            } else {

                // Usuario o contraseña incorrectos
                Toast.makeText(LoginActivity.this,
                        "Correo o contraseña incorrectos",
                        Toast.LENGTH_SHORT).show();
            }

        });

        // Pulsar en "Olvidé mi contraseña"
        tvOlvideContrasena.setOnClickListener(v -> {
            Toast.makeText(LoginActivity.this,
                    "Aquí irá la recuperación de contraseña",
                    Toast.LENGTH_SHORT).show();
        });

        // Pulsar en "Registrarse"
        tvNoTengoCuenta.setOnClickListener(v -> {
            Toast.makeText(LoginActivity.this,
                    "Aquí irá la pantalla de registro",
                    Toast.LENGTH_SHORT).show();
        });

    }
}