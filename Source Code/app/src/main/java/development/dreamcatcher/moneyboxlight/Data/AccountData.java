package development.dreamcatcher.moneyboxlight.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import development.dreamcatcher.moneyboxlight.ApiService.ApiClient;
import development.dreamcatcher.moneyboxlight.ApiService.ApiUtils;

@Entity
public class AccountData {

    @PrimaryKey
    private Integer investorProductId;
    private Float moneyBoxState, accountState;

    public AccountData(Float moneyBoxState, Float accountState, Integer investorProductId) {

        this.investorProductId = investorProductId;
        this.moneyBoxState = moneyBoxState;
        this.accountState = accountState;
    }

    public Integer getInvestorProductId() {
        return investorProductId;
    }

    /*public void add10ToMoneyBox() {
        ApiClient apiClient = DataRepository.apiClient;
        ApiUtils.callApiAdd10ToMoneyBoxRequest(apiClient, investorProductId);
    }*/

    public void setInvestorProductId(Integer investorProductId) { this.investorProductId = investorProductId; }

    public Float getMoneyBoxState() { return moneyBoxState; }

    public void setMoneyBoxState(Float moneyBoxState) {
        this.moneyBoxState = moneyBoxState;
    }

    public Float getAccountState() { return accountState; }

    public void setAccountState(Float accountState) { this.accountState = accountState; }

}
