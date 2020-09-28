package com.josrangel.volleyejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UsuarioDetalleActivity extends AppCompatActivity {
    TextView tvId, tvTitle, tvUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_detalle);

        tvId = findViewById(R.id.tvId);
        tvUserId = findViewById(R.id.tvUserId);
        tvTitle = findViewById(R.id.tvTitulo);

        Usuario usuario = getIntent().getParcelableExtra(UsuarioAdapter.EXTRA_USUARIO);
        String title = usuario.getTitle();
        int id = usuario.getId();
        int userId = usuario.getUserId();

        tvTitle.setText(title);
        tvId.setText(String.valueOf(id));
        tvUserId.setText(String.valueOf(userId));
    }
}