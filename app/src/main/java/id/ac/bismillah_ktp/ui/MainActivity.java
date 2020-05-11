package id.ac.bismillah_ktp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import id.ac.bismillah_ktp.R;

public class MainActivity extends AppCompatActivity {
    public static final String key = "e708a4abf79fc10dd3f61f6ebf7ec58ded8f95b9ac001c86e94e4188e230cfea";
    View rView;
    String nik;
    ItemAdapter itemAdapter = new ItemAdapter();
    FastAdapter fastAdapter= FastAdapter.with(itemAdapter);
    Button backButton,findButton;

    EditText no_nik;
    TextView nama_ktp,tempat_lahir;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        no_nik= findViewById(R.id.nik);
        backButton = findViewById(R.id.backButton);
        nama_ktp= findViewById(R.id.nama);
        tempat_lahir= findViewById(R.id.tmplahir);
        findButton = findViewById(R.id.button2);
    }
    public void handleRequest(View view) {

        nik= no_nik.getText().toString();
        itemAdapter.clear();
        no_nik.setVisibility(View.INVISIBLE);
        findButton.setVisibility(View.INVISIBLE);
        backButton.setVisibility(View.VISIBLE);
    }
    public void handleBack(View view){
        no_nik.setVisibility(View.VISIBLE);
        findButton.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.INVISIBLE);
    }
    void setResponse(String m){
        Snackbar.make(rView,m, BaseTransientBottomBar.LENGTH_LONG).show();
    }
}
