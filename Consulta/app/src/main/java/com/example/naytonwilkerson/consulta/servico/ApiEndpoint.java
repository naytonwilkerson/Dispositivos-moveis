package com.example.naytonwilkerson.consulta.servico;

import com.example.naytonwilkerson.consulta.domain.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndpoint {

@GET("posts/{id}")
Call<Post> getPost(@Path("id") String postId);

}