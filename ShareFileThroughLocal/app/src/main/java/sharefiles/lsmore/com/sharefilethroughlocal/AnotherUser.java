package sharefiles.lsmore.com.sharefilethroughlocal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Simon_Li1 on 3/23/2017.
 */

public class AnotherUser implements Parcelable{


    private int id;
    private String userName;

    public AnotherUser(int id, String userName){
        this.id = id;
        this.userName = userName;
    }

    protected AnotherUser(Parcel in) {
        id = in.readInt();
        userName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(userName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AnotherUser> CREATOR = new Creator<AnotherUser>() {
        @Override
        public AnotherUser createFromParcel(Parcel in) {
            return new AnotherUser(in);
        }

        @Override
        public AnotherUser[] newArray(int size) {
            return new AnotherUser[size];
        }
    };

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
