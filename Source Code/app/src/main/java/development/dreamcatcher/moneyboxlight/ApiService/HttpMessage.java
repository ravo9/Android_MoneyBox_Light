package development.dreamcatcher.moneyboxlight.ApiService;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import development.dreamcatcher.moneyboxlight.Data.AccountData;

public class HttpMessage {

    @SerializedName("Products")
    @Expose
    List<HttpMessage.Product> products;

    private class Product {

        @SerializedName("ProductId")
        Integer productId;

        @SerializedName("InvestorProductId")
        Integer investorProductId;

        @SerializedName("Moneybox")
        Float moneyBoxState;

        @SerializedName("PlanValue")
        Float accountState;
    }

    public HttpMessage() {
        products = new ArrayList<>();
    }

    public AccountData getIsaAccountData() {

        Integer productId = products.get(0).productId;
        Integer investorProductId = products.get(0).investorProductId;
        Float moneyBoxState = products.get(0).moneyBoxState;
        Float accountState = products.get(0).accountState;
        return new AccountData(productId, moneyBoxState, accountState, investorProductId);
    }

    public AccountData getGiaAccountData() {

        Integer productId = products.get(1).productId;
        Integer investorProductId = products.get(1).investorProductId;
        Float moneyBoxState = products.get(1).moneyBoxState;
        Float accountState = products.get(1).accountState;
        return new AccountData(productId, moneyBoxState, accountState, investorProductId);
    }


    @SerializedName("Session")
    @Expose
    HttpMessage.Session session;

    private class Session {

        @SerializedName("BearerToken")
        String bearerToken ;
    }

    public String getBearerToken() {
        return session.bearerToken;
    }
}
