package com.jaipeh.actividaddatos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar clrd;
    Button btSiguiente;
    EditText etNombre;
    EditText etFecha;
    EditText etTelefono;
    EditText etEmail;
    EditText etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);

        etFecha = findViewById(R.id.etFecha);
        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clrd = Calendar.getInstance();
                int day = clrd.get(Calendar.DAY_OF_MONTH);
                int month = clrd.get (Calendar.MONTH);
                int year = clrd.get (Calendar.YEAR);

                DatePickerDialog picker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker View, int ayear, int amonth, int aday) {
                        etFecha.setText(aday + "/" + (amonth + 1) + "/" + ayear);
                    }
                }, year, month, day);
                picker.show();
            }
        });

        btSiguiente = findViewById(R.id.bt1);
        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Confirmacion.class);
                intent.putExtra("nombre",etNombre.getText().toString());
                intent.putExtra("fecha",etFecha.getText().toString());
                intent.putExtra("telefono",etTelefono.getText().toString());
                intent.putExtra("email",etEmail.getText().toString());
                intent.putExtra("desc",etDescripcion.getText().toString());
                startActivity(intent);

            }
        });

    }
}