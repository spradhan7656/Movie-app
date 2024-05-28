package com.tv.movieapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    String url="https://jsonplaceholder.typicode.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.Text_view1);
        tv.setText("");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Myapi api=retrofit.create(Myapi.class);
        Call<List<Data_Model>> call=api.getmodel();
        call.enqueue(new Callback<List<Data_Model>>() {
            @Override
            public void onResponse(Call<List<Data_Model>> call, Response<List<Data_Model>> response)
            {
                List<Data_Model>data=response.body();
                for (int i=0;i<data.size();i++)
                {
                    tv.append("Sl NO:-"+data.get(i).getId()+"\nTitle:-"+data.get(i).getTitle()+"\nbody:-"+data.get(i).getBody()+"\n\n\n");
                }
            }
            @Override
            public void onFailure(Call<List<Data_Model>> call, Throwable throwable)
            {

            }
        });
    }
}