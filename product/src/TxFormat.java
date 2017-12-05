/**
 * Created by daehyun on 2017. 12. 5..
 */
public abstract class TxFormat {
    public enum txDataType  {txType1, txType2, txType3};
    private txDataType type;
    private Object data;

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
