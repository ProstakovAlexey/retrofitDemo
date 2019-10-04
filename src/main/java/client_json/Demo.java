package client_json;

import com.google.gson.annotations.Expose;

public class Demo {
    @Expose(serialize = false, deserialize = false) private int i=1;
    public String s="hello";
    float f = (float) 12.98;
}
