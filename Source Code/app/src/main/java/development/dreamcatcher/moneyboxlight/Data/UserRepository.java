package development.dreamcatcher.moneyboxlight.Data;

import javax.inject.Singleton;

import development.dreamcatcher.moneyboxlight.ApiService.ApiLoginClient;
import development.dreamcatcher.moneyboxlight.ApiService.ApiUtils;


@Singleton
public class UserRepository {

    public static UserRepository userRepository;

    private ApiLoginClient apiLoginClient;
    private String bearerToken;

    public static void initialize() {

        if (userRepository == null)
            userRepository = new UserRepository();
    }

    public UserRepository() {

        this.apiLoginClient = ApiUtils.getAPIService();
    }

    public void getBearerToken() {
        ApiUtils.callApiLoginRequest(apiLoginClient);
    }

    public void setBearerToken(String bearerToken) { this.bearerToken = bearerToken; }

    public boolean isLoggedIn() {

        if (bearerToken == null)
            return false;
        else
            return true;
    }
}
