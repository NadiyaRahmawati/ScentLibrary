package com.nadiya.scentlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
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

        binding.etMerek.setText(add.getMerekPerfume());
        binding.etNamaPefume.setText(add.getNamaPerfume());
        binding.etDeskripsi.setText(add.getDeskripsiPerfume());
        binding.etJenis.setText(add.getJenisPefume());
        binding.etUkuran.setText(add.getUkuranPerfume());
        binding.etHarga.setText(add.getHargaPerfume());
        binding.etGender.setText(add.getGenderPerfume());

        binding.btnUpdatePerfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Merek = binding.etMerek.getText().toString();
                String NamaPerfume = binding.etNamaPefume.getText().toString();
                String Deskripsi = binding.etDeskripsi.getText().toString();
                String Jenis = binding.etJenis.getText().toString();
                int Ukuran = Integer.parseInt(binding.etUkuran.getText().toString());
                int Harga = Integer.parseInt(binding.etHarga.getText().toString());
                String Gender = binding.etGender.getText().toString();

                boolean bolehUpdate = true;
                if (TextUtils.isEmpty(Merek)) {
                    bolehUpdate = false;
                    binding.etMerek.setError("Merek tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(NamaPerfume)) {
                    bolehUpdate = false;
                    binding.etNamaPefume.setError("Nama Perfume tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(Deskripsi)) {
                    bolehUpdate = false;
                    binding.etDeskripsi.setError("Deskripsi tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(Jenis)) {
                    bolehUpdate = false;
                    binding.etJenis.setError("Jenis tidak boleh kosong!");
                }
                if (Ukuran == 0) {
                    bolehUpdate = false;
                    binding.etUkuran.setError("Ukuran tidak boleh kosong!");
                }
                if (Harga == 0) {
                    bolehUpdate = false;
                    binding.etHarga.setError("Harga tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(Gender)) {
                    bolehUpdate = false;
                    binding.etGender.setError("Gender tidak boleh kosong!");
                }

                if (bolehUpdate) {
                    updateAdd(id, Merek, NamaPerfume, Deskripsi, Jenis, Ukuran, Harga, Gender);
                }
            }
        });
    }

    private void updateAdd(String userId, String Merek, String NamaPerfume , String Deskripsi , String Jenis, int Ukuran, int Harga, String Gender) {
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