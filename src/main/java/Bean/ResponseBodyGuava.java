package Bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBodyGuava {
    @JsonProperty
    private String available_amount;

    public ResponseBodyGuava(String available_amount) {
        this.available_amount = available_amount;
    }

    public ResponseBodyGuava() {
    }

    public String getAvailable_amount() {
        return available_amount;
    }

    public void setAvailable_amount(String available_amount) {
        this.available_amount = available_amount;
    }

    @Override
    public String toString() {
        return "ResponseBodyGuava{" +
                "available_amount='" + available_amount + '\'' +
                '}';
    }
}
