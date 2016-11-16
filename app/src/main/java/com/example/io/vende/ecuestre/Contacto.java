package com.example.io.vende.ecuestre;

/**
 * Created by MauricioVende on 09/11/2016.
 */

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Contacto extends Fragment implements View.OnClickListener{
    EditText et_nombre, et_correo, et_mensaje;
    Button btn_contacto;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contactoView = inflater.inflate(R.layout.fm_contacto,container,false);
        et_nombre = (EditText)contactoView.findViewById(R.id.et_nombre);
        et_correo = (EditText)contactoView.findViewById(R.id.et_correo);
        et_mensaje = (EditText)contactoView.findViewById(R.id.et_mensaje);
        btn_contacto = (Button)contactoView.findViewById(R.id.btn_contacto);

        btn_contacto.setOnClickListener(this);

        return contactoView;
    }

    @Override
    public void onClick(View v) {
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject respuesta =  new JSONObject(response);
                    boolean success = respuesta.getBoolean("success");
                    //Toast.makeText(getActivity().getApplicationContext(),success +"",Toast.LENGTH_SHORT).show();

                    if(success){
                        et_nombre.setText("");
                        et_correo.setText("");
                        et_mensaje.setText("");
                        new AlertDialog.Builder(getActivity())
                                .setMessage("El correo se envio correctamente")
                                .setPositiveButton("Aceptar", null)
                                .show();

                    }
                    else{
                        new AlertDialog.Builder(getActivity())
                                .setMessage("Hubo un error al enviar al correo intente de nuevo mas tarde")
                                .setNegativeButton("Aceptar", null)
                                .show();
                    }
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        };




        if(et_nombre.getText().toString().equals("") || et_correo.getText().toString().equals("") || et_mensaje.getText().toString().equals("")){
            Toast.makeText(getActivity().getApplicationContext(),"Favor de llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
        else{
            String nombre = et_nombre.getText().toString();
            String correo = et_correo.getText().toString();
            String mensaje = et_mensaje.getText().toString();

            ContactoRequest contactoRequest = new ContactoRequest(mensaje,nombre, correo, listener);
            RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
            queue.add(contactoRequest);
        }
    }
}
