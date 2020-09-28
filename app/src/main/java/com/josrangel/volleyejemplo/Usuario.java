package com.josrangel.volleyejemplo;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Usuario implements Parcelable {

    int userId;
    int id;
    String title;
    boolean completed;

    Usuario(JSONObject jsonObject){
        try{
            userId= jsonObject.getInt("userId");
            id= jsonObject.getInt("id");
            title= jsonObject.getString("title");
            completed= jsonObject.getBoolean("completed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Usuario(Parcel source) {
        userId = source.readInt();
        id = source.readInt();
        title = source.readString();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompletado() {
        return completed;
    }

    public void setCompletado(boolean completado) {
        this.completed = completado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completado=" + completed +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeInt(id);
        dest.writeString(title);
        //dest.writeBoolean(completado);
    }

    public static Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel source) {
            return new Usuario(source) {
            };
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}
