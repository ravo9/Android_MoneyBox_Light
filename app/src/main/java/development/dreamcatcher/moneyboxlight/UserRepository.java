package development.dreamcatcher.moneyboxlight;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Response;


@Singleton
public class UserRepository {
    //private final ApiLoginClient apiLoginClient;
    //private final Executor executor;

    @Inject
    public UserRepository() {
        //this.apiLoginClient = apiLoginClient;
        //this.executor = executor;
    }

    /*@Inject
    public UserRepository(ApiLoginClient apiLoginClient, Executor executor) {
        //this.apiLoginClient = apiLoginClient;
        //this.executor = executor;
    }*/

    /*public User getUser(String userId) {
        executor.execute(() -> {
            try {
                Response response = apiLoginClient.getUser(userId).execute();
            }
            catch(Exception e){}
        });
        return null;
    }*/
}
