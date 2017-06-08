package bwie.com.list;

/**
 * Created by $USER_NAME on 2017/6/8.
 */

public class Bean {

    String content;
    boolean isChecked;

    public Bean(String content, boolean isChecked) {
        this.content = content;
        this.isChecked = isChecked;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
