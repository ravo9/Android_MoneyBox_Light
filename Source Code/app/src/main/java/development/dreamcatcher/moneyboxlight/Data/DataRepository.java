package development.dreamcatcher.moneyboxlight.Data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import development.dreamcatcher.moneyboxlight.ApiService.ApiClient;
import development.dreamcatcher.moneyboxlight.ApiService.ApiUtils;


@Singleton
public class DataRepository {

    public static DataRepository dataRepository;
    public static ApiClient apiClient;

    private AccountDao accountDao;
    private Executor executor;

    private String bearerToken;
    private Integer isaInvestorProductId;

    public LiveData<AccountData> isaAccountData() {

        final MutableLiveData<AccountData> data = new MutableLiveData<>();
        ApiUtils.callGetIsaAccountDataRequest(apiClient, data);
        return data;

        //refreshAccountData();
        //return accountDao.load();
    }

    public static void initialize() {

        if (dataRepository == null) {
            dataRepository = new DataRepository();
            dataRepository.apiClient = ApiUtils.getAPIService();
        }
    }

    //@Inject
    DataRepository() {

        //this.accountDao  = accountDao;
        //this.executor = new Executor();
        //dataRepository = this;
        //dataRepository.apiClient = ApiUtils.getAPIService();
    }

    private void refreshAccountData() {
        executor.execute(() -> {
            try{
                MutableLiveData<AccountData> data = new MutableLiveData<>();
                ApiUtils.callGetIsaAccountDataRequest(apiClient, data);
                accountDao.save(data.getValue());
            }
            catch(Exception e) {}
        });
    }

    public void add10ToMoneyBox(Integer investorProductId) {
        ApiUtils.callApiAdd10ToMoneyBoxRequest(apiClient, investorProductId);
    }

    public void fetchBearerToken() {
        ApiUtils.callApiLoginRequest(apiClient);
    }

    public String getBearerToken() { return bearerToken; }
    public void setBearerToken(String bearerToken) { this.bearerToken = bearerToken; }

    public void setIsaInvestorProductId(Integer isaInvestorProductId) { this.isaInvestorProductId = isaInvestorProductId; }
    public Integer getIsaInvestorProductId() { return this.isaInvestorProductId; }

    public boolean isLoggedIn() {

        if (bearerToken == null)
            return false;
        else
            return true;
        //return true;
    }
}
