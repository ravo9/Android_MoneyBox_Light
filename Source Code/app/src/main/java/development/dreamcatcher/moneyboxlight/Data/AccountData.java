package development.dreamcatcher.moneyboxlight.Data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "accounts")
public class AccountData {

    @PrimaryKey
    @ColumnInfo(name = "product_id")
    private Integer productId;

    @ColumnInfo(name = "investor_product_id")
    private Integer investorProductId;

    @ColumnInfo(name = "money_box_state")
    private Float moneyBoxState;

    @ColumnInfo(name = "account_state")
    private Float accountState;

    public AccountData(Integer productId, Float moneyBoxState, Float accountState, Integer investorProductId) {

        this.productId = productId;
        this.investorProductId = investorProductId;
        this.moneyBoxState = moneyBoxState;
        this.accountState = accountState;
    }

    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) { this.productId = productId; }

    public Integer getInvestorProductId() {
        return investorProductId;
    }
    public void setInvestorProductId(Integer investorProductId) { this.investorProductId = investorProductId; }

    public Float getMoneyBoxState() { return moneyBoxState; }
    public void setMoneyBoxState(Float moneyBoxState) {
        this.moneyBoxState = moneyBoxState;
    }

    public Float getAccountState() { return accountState; }
    public void setAccountState(Float accountState) { this.accountState = accountState; }
}
