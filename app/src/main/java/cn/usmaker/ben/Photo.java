package cn.usmaker.ben;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/20.
 */
public class Photo implements Serializable {

    public String path;
    public int    id;
    public int    type; //1:path,2:id


    public Photo(String path, int id, int type) {
        this.path = path;
        this.id = id;
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
