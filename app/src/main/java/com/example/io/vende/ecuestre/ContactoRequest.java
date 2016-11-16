package com.example.io.vende.ecuestre;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MauricioVende on 10/11/2016.
 */

public class ContactoRequest extends StringRequest {
    private static final String CONTACTO_URL = "http://ecuestre.digital/app/contacto.php";
    private Map<String,String> params;

    public ContactoRequest(String mensaje, String nombre, String correo, Response.Listener<String> listener){
        super(Method.POST, CONTACTO_URL, listener, null);
        params = new HashMap<>();
        params.put("nombre", nombre);
        params.put("mensaje", mensaje);
        params.put("correo", correo);
    }

    public Map<String, String> getParams() { return params; }
}
