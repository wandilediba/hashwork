package hashwork.domain.ui.util;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String code;
    private String name;
    private String symbol;

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    private Currency(Builder builder){
        this.id = builder.id;
        this.code = builder.code;
        this.name = builder.name;
        this.symbol = builder.symbol;
    }


    public static class Builder {

        private String id;
        private String code;
        private String name;
        private String symbol;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder code(String value){
            this.code = value;
            return this;
        }

        public Builder name(String value){
            this.name = value;
            return this;
        }

        public Builder symbol(String value){
            this.symbol = value;
            return this;
        }

        public Builder copy(Currency value) {
            this.id = value.id;
            this.code = value.code;
            this.name = value.name;
            this.symbol = value.symbol;

            return this;
        }

        public Currency build(){
            return new Currency(this);
        }


    }
}
