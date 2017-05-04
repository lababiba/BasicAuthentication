package com.example.lababiba.basicauthentication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button startBtn;
    Button echoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.start);
        startBtn.setOnClickListener(start);
        echoBtn = (Button) findViewById(R.id.echo);
        echoBtn.setOnClickListener(echo);
    }

    View.OnClickListener start = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener echo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Api api = NetworkService.createService(Api.class);

            Call<Response<String>> request = api.sendEcho();
            request.enqueue(new Callback<Response<String>>() {
                @Override
                public void onResponse(Call<Response<String>> call, Response<Response<String>> response) {
                    Toast.makeText(MainActivity.this, "All spid" + response.body(), Toast.LENGTH_SHORT).show();
                    System.out.println("Echo request "+ response.code());
                }

                @Override
                public void onFailure(Call<Response<String>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                }
            });
        }
    };
}
