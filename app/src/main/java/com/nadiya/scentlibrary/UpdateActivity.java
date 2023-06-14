package com.nadiya.scentlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.nadiya.scentlibrary.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {

    private ActivityUpdateBinding binding;
    private Add add;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        add = getIntent().getParcelableExtra("EXTRA_DATA");
        String id = add.getId();

        binding.etNama.setText(daftar.getNama());
        binding.etAlamat.setText(daftar.getAlamat());
        binding.etDeskripsi.setText(daftar.getDeskripsi());
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = binding.etNama.getText().toString();
                String alamat = binding.etAlamat.getText().toString();
                String deskripsi= binding.etDeskripsi.getText().toString();

                boolean bolehUpdate = true;
                if (TextUtils.isEmpty(nama)) {
                    bolehUpdate = false;
                    binding.etNama.setError("Nama tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(alamat)) {
                    bolehUpdate = false;
                    binding.etAlamat.setError("Alamat tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(deskripsi)) {
                    bolehUpdate = false;
                    binding.etDeskripsi.setError("Nama tidak boleh kosong!");
                }


                if (bolehUpdate) {
                    updateUnggah(id,nama,alamat,deskripsi);
                }
            }
        });
    }

    private void updateUnggah(String userId, String nama , String alamat , String deskripsi) {
        binding.progressBar.setVisibility(View.VISIBLE);

        binding.progressBar.setVisibility(View.GONE);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}