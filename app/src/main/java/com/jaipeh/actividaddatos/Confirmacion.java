package com.jaipeh.actividaddatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    Button btEditar;
    TextView tvNombre;
    TextView tvFecha;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmacion);

        btEditar        = findViewById(R.id.btEditar);
        tvNombre        = findViewById(R.id.tvNombre);
        tvFecha         = findViewById(R.id.tvFecha);
        tvTelefono      = findViewById(R.id.tvTelefono);
        tvEmail         = findViewById(R.id.tvEnail);
        tvDescripcion   = findViewById(R.id.tvDescripcion);

        Bundle bundle = getIntent().getExtras();

        String nom = bundle.getString("nombre");
        tvNombre.setText(nom);

        String f_nac = bundle.getString("fecha");
        tvFecha.setText(f_nac);

        String tel = bundle.getString("telefono");
        tvTelefono.setText(tel);

        String em = bundle.getString("email");
        tvEmail.setText(em);

        String des = bundle.getString("desc");
        tvDescripcion.setText(des);

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
    }
}