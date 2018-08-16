package development.dreamcatcher.moneyboxlight.ApiService;

import android.util.Log;
import development.dreamcatcher.moneyboxlight.Data.UserRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiUtils {

    private ApiUtils() {}

    private static final String BASE_URL = "https://api-test00.moneyboxapp.com";

    public static ApiLoginClient getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiLoginClient.class);
    }

    public static void callApiLoginRequest(ApiLoginClient apiLoginClient) {

        apiLoginClient.savePost("test+env12@moneyboxapp.com", "Money$$box@107", "").enqueue(new Callback<HttpMessage>() {

            @Override
            public void onResponse(Call<HttpMessage> call, Response<HttpMessage> response) {

                Log.d("CODE: ", String.valueOf(response.code()));

                if(response.isSuccessful()) {
                    Log.i("INFO: ", "Token: " + response.body().getBearerToken());
                    UserRepository.userRepository.setBearerToken(response.body().getBearerToken());
                }
            }

            @Override
            public void onFailure(Call<HttpMessage> call, Throwable t) {
                Log.e("ERROR: ", "Unable to submit request to API.");
            }
        });
    }
}