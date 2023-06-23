package com.nadiya.scentlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.nadiya.scentlibrary.databinding.ActivityAddPerfumeBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                    String userid = Utilities.getValue(AddPerfumeActivity.this, "xUserId");
                    addPerfume(userid, merek, nama, deskripsi, jenis, Ukuran, Harga, gender);
                }
            }
        });
    }

    private void addPerfume(String userid, String merek, String nama, String deskripsi, String jenis, int ukuran, int harga, String gender) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = Utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.addPerfume(merek, nama, deskripsi, jenis, ukuran, harga, gender, userid);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.code() == 200) {
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        Toast.makeText(AddPerfumeActivity.this, message, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddPerfumeActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddPerfumeActivity.this, "Response " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(AddPerfumeActivity.this, "Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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