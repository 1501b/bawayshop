package shop.bawei.com.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class BaseListResponse<T> implements Serializable {
  private static final long serialVersionUID = -1736555174786656870L;
  protected int code;
  @SerializedName("msg")
  protected String message;
  @SerializedName("data")
  private List<T> listData;

  public List<T> getListData() {
    return listData;
  }


  public String getMessage() {
    return message;
  }
}
