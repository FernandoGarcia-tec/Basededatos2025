package com.example.basededatos2025.ui.agregar;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.basededatos2025.database.Conexion;
import com.example.basededatos2025.databinding.FragmentAgregarBinding;

public class AgregarFragment extends Fragment {

    private FragmentAgregarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AgregarViewModel agregarViewModel =
                new ViewModelProvider(this).get(AgregarViewModel.class);

        binding = FragmentAgregarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

// Verifica que los campos no estén vacíos antes de convertirlos
        if (!binding.txtclave.getText().toString().isEmpty() &&
                !binding.txtNombre.getText().toString().isEmpty() &&
                !binding.txtSueldo.getText().toString().isEmpty()) {

            int clave = Integer.parseInt(binding.txtclave.getText().toString());
            String nombre = binding.txtNombre.getText().toString();
            float sueldo = Float.parseFloat(binding.txtSueldo.getText().toString());

            this.AgregarCliente(clave, nombre, sueldo);
        } else {
            Toast.makeText(getContext(), "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
        }
        //Leer el boton
        Button btnAdd = binding.button;
        btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Guardar", Toast.LENGTH_SHORT).show();
            }
        });
        final TextView textView = binding.textGallery;
        agregarViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    //Metodo para insertar clientes en la tabla clientes
    private void AgregarCliente(int vClave,String vNombre,Float vSueldo){
        //creamos la conexion
        Conexion con = new Conexion(getContext(), "dbclientes", null, 1);
        //Creamos un objeto en la sql
        SQLiteDatabase db = con.getWritableDatabase();
        //Objeto tipo buffer
        ContentValues valores = new ContentValues();
        //Escribimos los valores en el contValues
        valores.put("clave", vClave);
        valores.put("nombre", vNombre);
        valores.put("sueldo", vSueldo);

        //Insertamos los valores en la tabla clientes
        long datos = db.insert("clientes", "clave", valores);

        if(datos > 0){
            Toast.makeText(getContext(), "Cliente guardado", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getContext(), "Error al guardar", Toast.LENGTH_SHORT).show();

        }
        db.close();

    }
}