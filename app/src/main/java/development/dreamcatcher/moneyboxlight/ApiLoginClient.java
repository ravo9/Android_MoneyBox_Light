package development.dreamcatcher.moneyboxlight;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiLoginClient {

    @GET("http://192.168.0.48:8081/api/profile/{user}")
    Call<User> getUser(@Path("user") String userId);
}