package com.nadiya.scentlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nadiya.scentlibrary.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private AddViewAdapter addViewAdapter;

    private List<Add> data;

    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (!Utilities.checkValue(MainActivity.this, "xUserId")){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        addViewAdapter = new AddViewAdapter();
        binding.rvAdd.setLayoutManager(new LinearLayoutManager(this));
        binding.rvAdd.setAdapter(addViewAdapter);

        binding.fabInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPerfumeActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllAdd();
    }

    private void getAllAdd() {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = Utilities.getRetrofit().create(APIService.class);
        Call<ValueData<List<Add>>> call = api.getAdd();
        call.enqueue(new Callback<ValueData<List<Add>>>() {
            @Override
            public void onResponse(Call<ValueData<List<Add>>> call, Response<ValueData<List<Add>>> response) {
                binding.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ValueData<List<Add>>> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(MainActivity.this, "Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //memanggil data add dari server
        binding.progressBar.setVisibility(View.GONE);
    }

    public boolean onCleateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_perfume, menu);
        return  true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout){
            Utilities.clearuser(this);
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}