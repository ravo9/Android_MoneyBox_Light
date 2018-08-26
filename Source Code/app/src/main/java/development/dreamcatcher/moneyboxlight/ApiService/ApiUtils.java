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

    public static void requestLogin(ApiClient apiClient) {

        apiClient.login("test+env12@moneyboxapp.com", "Money$$box@107", "").enqueue(new Callback<HttpMessage>() {

            @Override
            public void onResponse(Call<HttpMessage> call, Response<HttpMessage> response) {

                Log.i("HTTP CODE: ", String.valueOf(response.code()));

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


    public static MutableLiveData<AccountData> requestAccountData(Integer accountType, ApiClient apiClient, MutableLiveData<AccountData> data) {

        // 1 - ISA Account Type
        // 2 - GIA Account Type

        String bearerToken = "Bearer " + DataRepository.dataRepository.getBearerToken();
        apiClient.getAccountData(bearerToken).enqueue(new Callback<HttpMessage>() {

            @Override
            public void onResponse(Call<HttpMessage> call, Response<HttpMessage> response) {

                Log.d("HTTP CODE: ", String.valueOf(response.code()));

                if(response.isSuccessful()) {

                    // Update internal DB
                    if (accountType == 1)
                        DataRepository.updateStoredAccount(1, response.body().getIsaAccountData());
                    else if (accountType == 2)
                        DataRepository.updateStoredAccount(2, response.body().getGiaAccountData());

                    // Update stored investor products IDs.
                    if (accountType == 1)
                        DataRepository.dataRepository.setIsaInvestorProductId(response.body().getIsaAccountData().getInvestorProductId());
                    else if (accountType == 2)
                        DataRepository.dataRepository.setGiaInvestorProductId(response.body().getGiaAccountData().getInvestorProductId());

                    // Return proper account data to the caller
                    if (data != null) {
                        if (accountType == 1)
                            data.setValue(response.body().getIsaAccountData());
                        else if (accountType == 2)
                            data.setValue(response.body().getGiaAccountData());
                    }
                }
            }

            @Override
            public void onFailure(Call<HttpMessage> call, Throwable t) {
                Log.e("ERROR: ", "Unable to submit request to API.");
            }
        });

        return data;
    }


    public static void requestAdd10MoneyBox(Integer accountType, ApiClient apiClient, Integer investorProductId) {

        String bearerToken = "Bearer " + DataRepository.dataRepository.getBearerToken();
        apiClient.moneyBoxAdd10( bearerToken, 10.0f, investorProductId).enqueue(new Callback<HttpMessage>() {

            @Override
            public void onResponse(Call<HttpMessage> call, Response<HttpMessage> response) {

                Log.i("HTTP CODE: ", String.valueOf(response.code()));

                if(response.isSuccessful())
                    Log.i("INFO: ", "10 Pounds added successfully!");

                // Refresh stored account data ( internal DB )
                requestAccountData(accountType, apiClient, null);
            }

            @Override
            public void onFailure(Call<HttpMessage> call, Throwable t) {
                Log.e("ERROR: ", "Unable to submit request to API.");
            }
        });
    }
}