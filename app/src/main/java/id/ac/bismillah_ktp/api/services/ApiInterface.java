package id.ac.bismillah_ktp.api.services;

import id.ac.bismillah_ktp.api.models.Response;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/cekktp")
    Call<Response> getKTP(@Query("nik") String nik, @Query("nama") String nama, @Query("api_key") String key
    );
}
