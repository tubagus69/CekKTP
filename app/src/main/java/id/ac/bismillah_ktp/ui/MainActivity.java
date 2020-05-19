package id.ac.bismillah_ktp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.startapp.android.publish.adsCommon.StartAppSDK;

import net.khirr.android.privacypolicy.PrivacyPolicyDialog;

import java.util.ArrayList;

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
    private InterstitialAd mInterstitialAd;

    ItemAdapter itemAdapter = new ItemAdapter();
    FastAdapter fastAdapter= FastAdapter.with(itemAdapter);
    RelativeLayout boxResult;
    Button backButton,findButton;
    EditText no_nik;
    EditText nikInput,nameIput;
    TextView nama_ktp,tempat_lahir,jenis_kelamin,tps,nama_Propinsi,nama_Kabko,nama_Kec,nama_Kel;
    String nikValue,nameValue;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StartAppSDK.init(this, "203956990", true);
        StartAppSDK.setUserConsent(this,"pas", System.currentTimeMillis(), true);
        StartAppSDK.setUserConsent(this,"pas", System.currentTimeMillis(), false);
        setContentView(R.layout.activity_main);
        PrivacyPolicyDialog dialog = new PrivacyPolicyDialog(this,
                "https://localhost/terms",
                "https://localhost/privacy");
        dialog.addPoliceLine("This application uses a unique user identifier for advertising purposes, it is shared with third-party companies.");
        dialog.addPoliceLine("This application sends error reports, installation and send it to a server of the Fabric.io company to analyze and process it.");
        dialog.addPoliceLine("This application requires internet access and must collect the following information: Installed applications and history of installed applications, ip address, unique installation id, token to send notifications, version of the application, time zone and information about the language of the device.");
        dialog.addPoliceLine("All details about the use of data are available in our Privacy Policies, as well as all Terms of Service links below.");
        dialog.show();
        final Intent intent = new Intent(this, MainActivity.class);

        dialog.setOnClickListener(new PrivacyPolicyDialog.OnClickListener() {
            @Override
            public void onAccept(boolean isFirstTime) {
                Log.e("MainActivity", "Policies accepted");
                startActivity(intent);
                finish();
            }

            @Override
            public void onCancel() {
                Log.e("MainActivity", "Policies not accepted");
                finish();
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7780269601933724~7033255283");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        setContentView(R.layout.activity_main);
//        backButton = findViewById(R.id.backButton);
        nama_ktp= findViewById(R.id.nama);
        tempat_lahir= findViewById(R.id.tmplahir);
        jenis_kelamin=findViewById(R.id.jnskelamin);
        nikInput = findViewById(R.id.nikInput);
        tps = findViewById(R.id.tpsVIew);
        findButton = findViewById(R.id.button2);
        nameIput = findViewById(R.id.namaInput);
        nama_Propinsi = findViewById(R.id.namaPropinsi);
        nama_Kabko = findViewById(R.id.namaKabko);
        nama_Kec = findViewById(R.id.namaKec);
        nama_Kel = findViewById(R.id.namaKel);
        boxResult= findViewById(R.id.boxresult);
        boxResult.setVisibility(View.INVISIBLE);
        itemAdapter = new ItemAdapter();
        fastAdapter = FastAdapter.with(itemAdapter);
    }
    public void handleRequest(View view) {
//        mInterstitialAd.setAdListener(new AdListener(){
//            @Override
//            public void onAdClosed() {
//                super.onAdClosed();
//                mInterstitialAd.loadAd(new AdRequest.Builder().build());
//                mInterstitialAd.show();
//                getData();
//            }
//        });
//        if (mInterstitialAd.isLoaded()) {
//            mInterstitialAd.show();
//
//        } else {
//            Log.d("TAG", "The interstitial wasn't loaded yet.");
//        }
//    }
        itemAdapter.clear();

        nikValue = nikInput.getText().toString();
        nameValue = nameIput.getText().toString();
        boxResult.setVisibility(View.VISIBLE);
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
                if(response.body().getData() !=null){
//                    Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
//                    itemAdapter= new ItemAdapter<>();
//                    fastAdapter = FastAdapter.with(itemAdapter);
                        tps.setText("TPS \t\t: " + response.body().getData().getTps());
                        nama_ktp.setText("Nama \t: " + response.body().getData().getNama());
                        tempat_lahir.setText("\tTempat_Lahir  \t\t\t\t\t: " + response.body().getData().getTempatLahir());
                        jenis_kelamin.setText("\tJenis Kelamin  \t\t\t\t: " + response.body().getData().getJenisKelamin());
                        nama_Propinsi.setText("\tNama Propinsi  \t\t\t\t: " + response.body().getData().getNamaPropinsi());
                        nama_Kabko.setText("\tNama Kab/Kota  \t\t\t: " + response.body().getData().getNamaKabko());
                        nama_Kec.setText("\tNama Kecamatan  \t: " + response.body().getData().getNamaKec());
                        nama_Kel.setText("\tNama Kelurahan  \t\t: " + response.body().getData().getNamaKel());

                }else{
                    Toast.makeText(MainActivity.this, "Sorry, this word didn't match our record.Please check again.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure load data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setResponse(String m){
        Snackbar.make(rView,m, BaseTransientBottomBar.LENGTH_LONG).show();
    }
}
