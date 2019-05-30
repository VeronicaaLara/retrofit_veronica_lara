package com.ejercicio_retrofit.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ejercicio_retrofit.API.RestClient;
import com.ejercicio_retrofit.Adapter.GrupoAdapter;
import com.ejercicio_retrofit.Grupo.Grupo;
import com.ejercicio_retrofit.Grupo.Result;
import com.ejercicio_retrofit.R;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends Activity {

    private List<Result> data;
    private GrupoAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        RecyclerView rv = findViewById(R.id.recyclerList);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);

        data = new ArrayList<>();
        adapter = new GrupoAdapter(this,(ArrayList<Result>) data);
        rv.setAdapter(adapter);
        loadJSON();


    }

    private void loadJSON() {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestClient rc = retrofit.create(RestClient.class);
        Call<Grupo> call = rc.getData();
        call.enqueue(new Callback<Grupo>() {
            @Override
            public void onResponse(Call<Grupo> call, Response<Grupo> response) {

                switch (response.code()){
                    case 200:
                        Grupo grupo = response.body();
                        Log.e("retrofit grupo", ""+ grupo.getGrupos().toString());
                        data.addAll(grupo.getGrupos());
                        adapter.notifyDataSetChanged();
                    break;
                    case 401:

                        break;
                    default:

                        break;
                }

            }

            @Override
            public void onFailure(Call<Grupo> call, Throwable t) {
                Log.e("retrofit grupos", t.toString());

            }
        });
    }


}
