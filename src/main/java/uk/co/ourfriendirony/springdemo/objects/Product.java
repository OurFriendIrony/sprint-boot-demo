package uk.co.ourfriendirony.springdemo.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "description",
        "sku"
})
public class Product {

    private ObjectMapper mapper = new ObjectMapper();

    public Product(String desc, String sku) {
        this.setDescription(desc);
        this.setSku(sku);
    }
    public Product(){}

    @JsonProperty("description")
    private String description;
    @JsonProperty("sku")
    private String sku;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString(){
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "{\"error\":\"Couldn't parse JSON\"}";
        }
    }
}
