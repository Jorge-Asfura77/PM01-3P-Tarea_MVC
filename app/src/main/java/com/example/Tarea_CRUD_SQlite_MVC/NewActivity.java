package com.example.Tarea_CRUD_SQlite_MVC;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Tarea_CRUD_SQlite_MVC.database.DbEmployees;

public class NewActivity extends AppCompatActivity {

    EditText txtNombre, txtApellidos, txtEdad, txtDireccion, txtPuestos;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);


        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtEdad = findViewById(R.id.txtEdad);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtPuestos = findViewById(R.id.txtPuestos);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(!txtNombre.getText().toString().equals("") && !txtApellidos.getText().toString().equals("")) {

                    DbEmployees dbEmployees = new DbEmployees(NewActivity.this);
                    long id = dbEmployees.insertEmployee(txtNombre.getText().toString(), txtApellidos.getText().toString(), txtEdad.getText().toString(), txtDireccion.getText().toString(), txtPuestos.getText().toString());

                    if (id > 0) {
                        Toast.makeText(NewActivity.this, "Empleado agregado", Toast.LENGTH_SHORT).show();
                        limpiar();
                    } else {
                        Toast.makeText(NewActivity.this, "Error al agregar empleado", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(NewActivity.this, "Por favor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void limpiar() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        txtDireccion.setText("");
        txtPuestos.setText("");
    }
}