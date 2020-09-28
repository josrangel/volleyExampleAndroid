package com.josrangel.volleyejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.texto);

        conexion();
    }

    public void conexion(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.eluniversal.com";

        StringRequest stringRequest = new StringRequest(Request.Method.GET,url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                texto.setText("Content: " +response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        queue.add(stringRequest);
    }
}