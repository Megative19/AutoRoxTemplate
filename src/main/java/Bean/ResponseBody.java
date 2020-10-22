package Bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ResponseBody {
    @JacksonXmlProperty(localName="Success")
    private String Success;
    @JacksonXmlProperty(localName="Amount")
    private int amount;
    @JacksonXmlProperty(localName="Currency")
    private String Currency;
    @JacksonXmlProperty(localName="MAC")
    private String MAC;
    @JacksonXmlProperty(localName="PartnerId")
    private int PartnerId;
    @JacksonXmlProperty(localName="Login")
    private String login;

    public ResponseBody(String success, int amount, String currency, String MAC, int partnerId, String login) {
        Success = success;
        this.amount = amount;
        Currency = currency;
        this.MAC = MAC;
        PartnerId = partnerId;
        this.login = login;
    }

    public ResponseBody() {
    }

    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public int getPartnerId() {
        return PartnerId;
    }

    public void setPartnerId(int partnerId) {
        PartnerId = partnerId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "Success='" + Success + '\'' +
                ", amount=" + amount +
                ", Currency='" + Currency + '\'' +
                ", MAC='" + MAC + '\'' +
                ", PartnerId=" + PartnerId +
                ", login='" + login + '\'' +
                '}';
    }
}
