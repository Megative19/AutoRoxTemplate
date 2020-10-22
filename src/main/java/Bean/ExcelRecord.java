package Bean;

import java.util.Date;

public class ExcelRecord {
    private Integer requestId;
    private Integer amountFromRFI;
    private Date date;
    private String amountFromGuava;

    public ExcelRecord(Integer requestId, Integer amountFromRFI, String amountFromGuava,Date date) {
        this.requestId = requestId;
        this.amountFromRFI = amountFromRFI;
        this.date = date;
        this.amountFromGuava = amountFromGuava;
    }

    public ExcelRecord() {
   }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getAmountFromRFI() {
        return amountFromRFI;
    }

    public void setAmountFromRFI(Integer amountFromRFI) {
        this.amountFromRFI = amountFromRFI;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAmountFromGuava() {
        return amountFromGuava;
    }

    public void setAmountFromGuava(String amountFromGuava) {
        this.amountFromGuava = amountFromGuava;
    }

    @Override
    public String toString() {
        return "ExcelRecord{" +
                "requestId=" + requestId +
                ", amountFromRFI=" + amountFromRFI +
                ", date=" + date +
                ", amountFromGuava='" + amountFromGuava + '\'' +
                '}';
    }
}
