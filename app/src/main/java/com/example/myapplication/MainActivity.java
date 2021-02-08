package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyApiCall myApiCall = retrofit.create(MyApiCall.class);

        Call<DataMOdel> call = myApiCall.getData();
        call.enqueue(new Callback<DataMOdel>() {
            @Override
            public void onResponse(Call<DataMOdel> call, Response<DataMOdel> response) {
                if (response.code() != 200){
                    text.setText("Check connection");
                    return;
                }

                String jsony = "";

                jsony = "ID= " + response.body().getId() +
                        "UserID= " + response.body().getUserID() +
                        "Title= " + response.body().getTitle() +
                        "Completed= " + response.body().isCompleted();

                Log.i("My Activity", jsony);

                System.out.println(jsony);
                text.append(jsony);
            }

            @Override
            public void onFailure(Call<DataMOdel> call, Throwable t) {

            }
        });
    }
}