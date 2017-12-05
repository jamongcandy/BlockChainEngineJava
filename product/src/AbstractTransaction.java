/**
 * Created by daehyun on 2017. 12. 5..
 */
public abstract class AbstractTransaction {
    private Object data;

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
