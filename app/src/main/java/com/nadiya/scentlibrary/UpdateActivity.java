package com.nadiya.scentlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.nadiya.scentlibrary.databinding.ActivityUpdateBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    private void updateAdd(String Id, String Merek, String NamaPerfume , String Deskripsi , String Jenis, int Ukuran, int Harga, String Gender) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = Utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.updateAdd(Id, Merek, NamaPerfume, Deskripsi, Jenis, Ukuran, Harga, Gender);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.code() == 200){
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        Toast.makeText(UpdateActivity.this, message, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(UpdateActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(UpdateActivity.this, "Response" + response.code(), Toast.LENGTH_SHORT).show();
 }
            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error :" + t.getMessage());
                Toast.makeText(UpdateActivity.this, "Retrofit Error :" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


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