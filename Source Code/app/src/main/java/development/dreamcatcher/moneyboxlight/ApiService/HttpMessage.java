package development.dreamcatcher.moneyboxlight.ApiService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HttpMessage {

    @SerializedName("Session")
    @Expose
    Session session;

    private class Session {

        @SerializedName("BearerToken")
        String bearerToken ;
    }

    public String getBearerToken() {
        return session.bearerToken;
    }
}