package com.example.jadzan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.jadzan.data.adapter.JadzanAdapter;
import com.example.jadzan.data.model.JadzanResponse;
import com.example.jadzan.data.rest.JadzanService;
import com.example.jadzan.data.rest.JadzanApi;

import java.util.List;

import static com.example.jadzan.data.model.JadzanResponse.*;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    private List<DataBean> data;
    public JadzanApi jadzanApi;
    private JadzanAdapter jadzanAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading Data..");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        recyclerView = findViewById(R.id.rv_adzan);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

       // load();

        jadzanApi = JadzanService.getAPI().create(JadzanApi.class);
        Call<JadzanResponse> call = jadzanApi.getPrayerTimeByCity("Maros","ID");
        call.enqueue(new Callback<JadzanResponse>() {
            @Override
            public void onResponse(Call<JadzanResponse> call, Response<JadzanResponse> response) {
                pDialog.dismiss();

                data = response.body().getData();
                jadzanAdapter = new JadzanAdapter(data);
                recyclerView.setAdapter(jadzanAdapter);
                jadzanAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<JadzanResponse> call, Throwable t) {
                pDialog.dismiss();

            }

        });



    }







}
