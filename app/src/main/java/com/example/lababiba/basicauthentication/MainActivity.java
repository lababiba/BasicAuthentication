package com.example.lababiba.basicauthentication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button startBtn;
    Button echoBtn;
    Button getUserBtn;
    Api api = NetworkService.createService(Api.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.send_user);
        startBtn.setOnClickListener(start);
        echoBtn = (Button) findViewById(R.id.echo);
        echoBtn.setOnClickListener(echo);
        getUserBtn = (Button) findViewById(R.id.get_user);
        getUserBtn.setOnClickListener(getUsrOnClick);
    }

    View.OnClickListener start = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            User user = new User(123,"stanev", "Korolev", "gmail");
            Call<ResponseBody> request = api.createUser(user);
            request.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
    };

    View.OnClickListener echo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            api = NetworkService.createService(Api.class);

            Call<ResponseBody> request = api.sendEcho();
            request.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    Toast.makeText(MainActivity.this, "All spid" + response.code(), Toast.LENGTH_SHORT).show();
                    System.out.println("Echo request "+ response.code());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                }
            });
        }
    };

    View.OnClickListener getUsrOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Call<ResponseBody> request = api.getUsers();
            request.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
    };
}
