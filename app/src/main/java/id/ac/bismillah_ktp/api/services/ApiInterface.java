package id.ac.bismillah_ktp.api.services;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
public interface ApiInterface {
    @Multipart
    @GET("/cekktp")
    Call<ResponseBody> CekKTP(
            @Part MultipartBody.Part text
    );
}
