package com.nadiya.scentlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.nadiya.scentlibrary.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private AddViewAdapter addViewAdapter;

    private List<Add> data;

    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Utilities.checkValue(MainActivity.this, "xUserId")){
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
    protected void onRestart() {
        super.onRestart();
        getAllAdd();
    }

    private void getAllAdd() {
        binding.progressBar.setVisibility(View.VISIBLE);
        //memanggil data unggah dari server
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