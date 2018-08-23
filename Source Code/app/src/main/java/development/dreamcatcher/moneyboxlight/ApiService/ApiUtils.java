package development.dreamcatcher.moneyboxlight.ApiService;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import development.dreamcatcher.moneyboxlight.Data.AccountData;
import development.dreamcatcher.moneyboxlight.Data.DataRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiUtils {

    private static final String BASE_URL = "https://api-test00.moneyboxapp.com";

    private ApiUtils() {}

    public static ApiClient getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiClient.class);
    }

    public static void callApiLoginRequest(ApiClient apiClient) {

        apiClient.login("test+env12@moneyboxapp.com", "Money$$box@107", "").enqueue(new Callback<HttpMessage>() {

            @Override
            public void onResponse(Call<HttpMessage> call, Response<HttpMessage> response) {

                Log.d("HTTP CODE: ", String.valueOf(response.code()));

                if(response.isSuccessful()) {
                    Log.i("INFO: ", "Token: " + response.body().getBearerToken());
                    DataRepository.dataRepository.setBearerToken(response.body().getBearerToken());
                }
            }

            @Override
            public void onFailure(Call<HttpMessage> call, Throwable t) {
                Log.e("ERROR: ", "Unable to submit request to API.");
            }
        });
    }


    public static MutableLiveData<AccountData> callGetIsaAccountDataRequest(ApiClient apiClient, MutableLiveData<AccountData> data) {

        String bearerToken = "Bearer " + DataRepository.dataRepository.getBearerToken();
        apiClient.getAccountData(bearerToken).enqueue(new Callback<HttpMessage>() {

            @Override
            public void onResponse(Call<HttpMessage> call, Response<HttpMessage> response) {

                Log.d("HTTP CODE: ", String.valueOf(response.code()));

                if(response.isSuccessful()) {
                    data.setValue(response.body().getAccountData());
                    DataRepository.dataRepository.setIsaInvestorProductId(response.body().getAccountData().getInvestorProductId());
                }
            }

            @Override
            public void onFailure(Call<HttpMessage> call, Throwable t) {
                Log.e("ERROR: ", "Unable to submit request to API.");
            }
        });

        return data;
    }


    public static void callApiAdd10ToMoneyBoxRequest(ApiClient apiClient, Integer investorProductId) {

        String bearerToken = "Bearer " + DataRepository.dataRepository.getBearerToken();
        apiClient.moneyBoxAdd10( bearerToken, 10.0f, investorProductId).enqueue(new Callback<HttpMessage>() {

            @Override
            public void onResponse(Call<HttpMessage> call, Response<HttpMessage> response) {

                Log.d("HTTP CODE: ", String.valueOf(response.code()));

                if(response.isSuccessful())
                    Log.i("INFO: ", "10 added successfully!");
            }

            @Override
            public void onFailure(Call<HttpMessage> call, Throwable t) {
                Log.e("ERROR: ", "Unable to submit request to API.");
            }
        });
    }
}