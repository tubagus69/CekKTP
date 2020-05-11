package id.ac.bismillah_ktp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import id.ac.bismillah_ktp.R;
import id.ac.bismillah_ktp.api.helper.ServiceGenerator;
import id.ac.bismillah_ktp.api.models.Response;
import id.ac.bismillah_ktp.api.services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    public static final String key = "e708a4abf79fc10dd3f61f6ebf7ec58ded8f95b9ac001c86e94e4188e230cfea";
    View rView;
    String nik;
    ItemAdapter itemAdapter = new ItemAdapter();
    FastAdapter fastAdapter= FastAdapter.with(itemAdapter);
    Button backButton,findButton;

    EditText no_nik;
    EditText nikInput,nameIput;
    TextView nama_ktp,tempat_lahir;
    String nikValue,nameValue;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backButton = findViewById(R.id.backButton);
        nama_ktp= findViewById(R.id.nama);
        tempat_lahir= findViewById(R.id.tmplahir);
        nikInput = findViewById(R.id.nikInput);
        nameIput = findViewById(R.id.namaInput);
        findButton = findViewById(R.id.button2);
    }
    public void handleRequest(View view) {

        itemAdapter.clear();

        nikValue = nikInput.getText().toString();
        nameValue = nameIput.getText().toString();

        getData();
    }
    public void handleBack(View view){
        no_nik.setVisibility(View.VISIBLE);
        findButton.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.INVISIBLE);
    }

    public void getData( ){
        ApiInterface service = ServiceGenerator.createService(ApiInterface.class);
        Call<Response> call = service.getKTP(nikValue,nameValue,"0d69c24e4c2c2a758be0fdfa1a687e3a055dbbfa0675c123450bc7c423946ae1");
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Bedot", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setResponse(String m){
        Snackbar.make(rView,m, BaseTransientBottomBar.LENGTH_LONG).show();
    }
}
