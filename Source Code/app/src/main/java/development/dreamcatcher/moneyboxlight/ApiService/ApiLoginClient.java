package development.dreamcatcher.moneyboxlight.ApiService;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiLoginClient {

    @POST("/users/login")
    @Headers({
            "AppId: 3a97b932a9d449c981b595",
            //"Content-Type: application/json",
            "appVersion: 4.11.0",
            "apiVersion: 3.0.0"
    })
    @FormUrlEncoded
    Call<HttpMessage> savePost(@Field("Email") String email,
                               @Field("Password") String password,
                               @Field("Idfa") String idfa);

}