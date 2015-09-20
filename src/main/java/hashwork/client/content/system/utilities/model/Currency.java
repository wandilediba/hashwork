package hashwork.client.content.system.utilities.model;

import java.io.Serializable;

/**
 * Created by bulelani on 2015/09/19.
 */
public class Currency implements Serializable {

    private String id;
    private String code;
    private String name;
    private String symbol;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
