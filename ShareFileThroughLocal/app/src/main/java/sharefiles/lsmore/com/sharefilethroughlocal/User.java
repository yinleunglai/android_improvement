package sharefiles.lsmore.com.sharefilethroughlocal;

import java.io.Serializable;

/**
 * Created by Simon_Li1 on 3/23/2017.
 */

public class User implements Serializable {



    private int id;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
