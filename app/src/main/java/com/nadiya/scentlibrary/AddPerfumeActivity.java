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
                int Ukuran = Integer.parseInt(binding.etUkuran.getText().toString());
                int Harga = Integer.parseInt(binding.etHarga.getText().toString());
                String gender = binding.etGender.getText().toString();

                boolean bolehAdd = true;

                if (TextUtils.isEmpty(merek)) {
                    bolehAdd = false;
                    binding.etMerek.setError("Merek tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(nama)) {
                    bolehAdd = false;
                    binding.etNamaPefume.setError("Nama tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(deskripsi)) {
                    bolehAdd = false;
                    binding.etDeskripsi.setError("Deskripsi tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(jenis)) {
                    bolehAdd = false;
                    binding.etJenis.setError("Jenis tidak boleh kosong!");
                }
                if (Ukuran == 0) {
                    bolehAdd = false;
                    binding.etUkuran.setError("Ukuran tidak boleh kosong!");
                }
                if (Harga == 0) {
                    bolehAdd = false;
                    binding.etHarga.setError("Harga tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(gender)) {
                    bolehAdd = false;
                    binding.etGender.setError("Gender tidak boleh kosong!");
                }
                if (bolehAdd) {
                    String userId = Utilities.getValue(AddPerfumeActivity.this, "xUsername");
                    addPerfume(userId, merek, nama, deskripsi, jenis, Ukuran, Harga, gender);
                }
            }
        });
    }

    private void addPerfume(String userId, String merek, String nama, String deskripsi, String jenis, int ukuran, int harga, String gender) {
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