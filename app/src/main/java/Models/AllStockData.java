package Models;

/**
 * Created by Lobna on 2/8/2017.
 */
public class AllStockData {

    public String companySymbol;
    public String companyEn;
    public String companyAr;
    public String SellPrice = "0";
    public String BuyPrice = "0";
    public String CurrentPrice = "0";
    public String NoOfTrades = "0";
    public String TradeValue = "0";
    public String TradeVolume = "0";
    public String HighPrice = "0";
    public String LowPrice = "0";
    public String ChangePercentage = "0";
    public String ChangeValue = "0";
    public String changeSign = "0";

    public String getCompanySymbol() {
        return companySymbol;
    }

    public void setCompanySymbol(String companySymbol) {
        this.companySymbol = companySymbol;
    }

    public String getCompanyEn() {
        return companyEn;
    }

    public void setCompanyEn(String companyEn) {
        this.companyEn = companyEn;
    }

    public String getCompanyAr() {
        return companyAr;
    }

    public void setCompanyAr(String companyAr) {
        this.companyAr = companyAr;
    }

    public String getSellPrice() {
        return SellPrice;
    }

    public void setSellPrice(String sellPrice) {
        SellPrice = sellPrice;
    }

    public String getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        BuyPrice = buyPrice;
    }

    public String getCurrentPrice() {
        return CurrentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        CurrentPrice = currentPrice;
    }

    public String getNoOfTrades() {
        return NoOfTrades;
    }

    public void setNoOfTrades(String noOfTrades) {
        NoOfTrades = noOfTrades;
    }

    public String getTradeValue() {
        return TradeValue;
    }

    public void setTradeValue(String tradeValue) {
        TradeValue = tradeValue;
    }

    public String getTradeVolume() {
        return TradeVolume;
    }

    public void setTradeVolume(String tradeVolume) {
        TradeVolume = tradeVolume;
    }

    public String getHighPrice() {
        return HighPrice;
    }

    public void setHighPrice(String highPrice) {
        HighPrice = highPrice;
    }

    public String getLowPrice() {
        return LowPrice;
    }

    public void setLowPrice(String lowPrice) {
        LowPrice = lowPrice;
    }

    public String getChangePercentage() {
        return ChangePercentage;
    }

    public void setChangePercentage(String changePercentage) {
        ChangePercentage = changePercentage;
    }

    public String getChangeValue() {
        return ChangeValue;
    }

    public void setChangeValue(String changeValue) {
        ChangeValue = changeValue;
    }

    public String getChangeSign() {
        return changeSign;
    }

    public void setChangeSign(String changeSign) {
        this.changeSign = changeSign;
    }
}
