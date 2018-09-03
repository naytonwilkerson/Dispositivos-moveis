package com.example.naytonwilkerson.consulta;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.naytonwilkerson.consulta.domain.Post;
import com.example.naytonwilkerson.consulta.servico.ApiEndpoint;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private TextView resposta;
    private EditText entrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resposta  = findViewById(R.id.resposta);
        entrada = findViewById(R.id.entrada);

    }

    public void bt1(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        ApiEndpoint apiService = retrofit.create(ApiEndpoint.class);
        Call<Post> call = apiService.getPost(entrada.getText().toString());

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                resposta.setText(response.body().getTitle());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

}
