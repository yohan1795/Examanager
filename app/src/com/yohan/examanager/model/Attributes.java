package com.yohan.examanager.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Attributes implements Serializable, Parcelable
{

    private String type;
    private String url;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Parcelable.Creator<Attributes> CREATOR = new Creator<Attributes>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Attributes createFromParcel(Parcel in) {
            Attributes instance = new Attributes();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Attributes[] newArray(int size) {
            return (new Attributes[size]);
        }

    }
            ;
    private final static long serialVersionUID = 6281250454381232893L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(url);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }

}