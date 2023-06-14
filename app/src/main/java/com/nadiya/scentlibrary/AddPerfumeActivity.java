package com.nadiya.scentlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.nadiya.scentlibrary.databinding.ActivityAddPerfumeBinding;

public class AddPerfumeActivity extends AppCompatActivity {
    private ActivityAddPerfumeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddPerfumeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTambahPerfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String merek = binding.etMerek.getText().toString();
                String nama = binding.etNamaPefume.getText().toString();
                String deskripsi = binding.etDeskripsi.getText().toString();
                String jenis = binding.etJenis.getText().toString();
                String ukuran = binding.etUkuran.getText().toString();
                int harga = binding.etHarga.getText().toString();
                String gender = binding.etGender.getText().toString();

                boolean bolehUnggah = true;

                if (TextUtils.isEmpty(merek)) {
                    bolehUnggah = false;
                    binding.etMerek.setError("Merek tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(nama)) {
                    bolehUnggah = false;
                    binding.etNamaPefume.setError("Merek tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(deskripsi)) {
                    bolehUnggah = false;
                    binding.etDeskripsi.setError("Merek tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(jenis)) {
                    bolehUnggah = false;
                    binding.etJenis.setError("Merek tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(ukuran)) {
                    bolehUnggah = false;
                    binding.etUkuran.setError("Merek tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(harga)) {
                    bolehUnggah = false;
                    binding.etHarga.setError("Merek tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(gender)) {
                    bolehUnggah = false;
                    binding.etGender.setError("Merek tidak boleh kosong!");
                }

                if (bolehUnggah) {
                    String userId = Utilities.getValue(AddPerfumeActivity.this, "xUsername");
                    addPerfume(userId, merek,nama,deskripsi,jenis,ukuran,harga,gender);
                }
            }
        });
    }

    private void addPerfume(String userId, String merek,String nama,String deskripsi,String jenis,String ukuran,Integer harga,String gender) {
        binding.progressBar.setVisibility(View.VISIBLE);
        // proses untuk mengunggah konten...
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