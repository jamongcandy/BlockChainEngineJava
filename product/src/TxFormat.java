/**
 * Created by daehyun on 2017. 12. 5..
 */
public class TxFormat {
    public enum txDataType  {txType1, txType2, txType3};
    private txDataType type;
    private Object data;

    public TxFormat(txDataType type, Object data) {
        this.type = type;
        this.data = data;
    }

    public txDataType getType() {
        return type;
    }

    public void setType(txDataType type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
