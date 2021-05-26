package com.example.aplicacinandroidspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerOperaciones,spinerConvertir;
    EditText cajaPrimerNumero;
    EditText cajaRes;
    Convesiones calculos=new Convesiones();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.Converciones,
                android.R.layout.simple_spinner_item);
        spinnerOperaciones=findViewById(R.id.spinerTipoDeGrado);

        spinnerOperaciones.setAdapter(adaptador);
        spinnerOperaciones=findViewById(R.id.spinerTipoDeGrado);
        spinnerOperaciones.setOnItemSelectedListener(this);

        spinerConvertir=findViewById(R.id.spinerConvercionA);
        spinerConvertir.setOnItemSelectedListener(this);
        cajaPrimerNumero=findViewById(R.id.CajaNumeroIngresado);
        cajaRes=findViewById(R.id.cajaResultado);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ArrayAdapter contenidosinC = ArrayAdapter.createFromResource(this, R.array.ConvercionesSinC,
                android.R.layout.simple_spinner_item);
        ArrayAdapter contenidosinF = ArrayAdapter.createFromResource(this, R.array.ConvercionesSinF,
                android.R.layout.simple_spinner_item);
        ArrayAdapter contenidosinK = ArrayAdapter.createFromResource(this, R.array.ConvercionesSinK,
                android.R.layout.simple_spinner_item);

        if(parent.getId()==R.id.spinerTipoDeGrado){
            System.out.println("Entro al spiner 1");
            switch (parent.getItemAtPosition(position).toString()){
                case "C°":
                    spinerConvertir.setAdapter(contenidosinC);
                    break;
                case "F°":
                    spinerConvertir.setAdapter(contenidosinF);
                    break;
                case "K°":
                    spinerConvertir.setAdapter(contenidosinK);
                    break;

            }

        }
        if(parent.getId()==R.id.spinerConvercionA){
            System.out.println("Entro en el spiner 2");
            if(cajaPrimerNumero.getText().toString().isEmpty()){
                cajaPrimerNumero.setText(0+"");
            }else{
                if(spinerConvertir.getSelectedItem().toString().equals("C°")){
                    
                }
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}