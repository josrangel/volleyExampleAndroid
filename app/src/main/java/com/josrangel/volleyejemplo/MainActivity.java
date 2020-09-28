package com.josrangel.volleyejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView texto;
    ListView listView;
    ArrayList<Usuario> usuarios = new ArrayList<>();
    UsuarioAdapter usuarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //texto = findViewById(R.id.texto); // DESCOMENTAR PARA LOS METODOS
        listView = findViewById(R.id.lvUsuarios);
        usuarioAdapter = new UsuarioAdapter(this,usuarios);
        //conexionElUniversal();
        //conexionJsonPlaceholderObject();
        conexionJsonArrayPlaceholderObject();
    }

    public void conexionJsonArrayPlaceholderObject(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://jsonplaceholder.typicode.com/todos";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i("lala",response.toString());
                for (int i=0; i<response.length(); i++){

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Log.i("lala",jsonObject.toString());
                        Usuario usuario = new Usuario(jsonObject);
                        usuarios.add(usuario);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                listView.setAdapter(usuarioAdapter);
                //texto.setText("Content: " + response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });


        queue.add(jsonArrayRequest);
    }

    public void conexionJsonPlaceholderObject(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://jsonplaceholder.typicode.com/todos/1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Usuario usuario=new Usuario(response);
                texto.setText(usuario.toString());
                //texto.setText("Content: " + response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });


        queue.add(jsonObjectRequest);
    }

    public void conexionElUniversal(){
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