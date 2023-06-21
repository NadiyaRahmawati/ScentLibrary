package com.nadiya.scentlibrary;

import android.os.Parcel;
import android.os.Parcelable;

public class Add implements Parcelable {
    private String id;
    private String merekperfume;
    private String namaperfume;
    private String deskripsiperfume;
    private String jenisperfume;
    private Integer ukuranperfume;
    private Integer hargaperfume;
    private String genderperfume;

    protected Add(Parcel in) {
        id = in.readString();
        merekperfume = in.readString();
        namaperfume = in.readString();
        deskripsiperfume = in.readString();
        jenisperfume = in.readString();
        ukuranperfume = in.readInt();
        hargaperfume = in.readInt();
        genderperfume = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(merekperfume);
        dest.writeString(namaperfume);
        dest.writeString(deskripsiperfume);
        dest.writeString(jenisperfume);
        dest.writeInt(ukuranperfume);
        dest.writeInt(hargaperfume);
        dest.writeString(genderperfume);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Add> CREATOR = new Creator<Add>() {
        @Override
        public Add createFromParcel(Parcel in) {
            return new Add(in);
        }

        @Override
        public Add[] newArray(int size) {
            return new Add[size];
        }
    };
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerekPerfume() {
        return merekperfume;
    }

    public void setMerekPerfume(String MerekPerfume) {
        this.merekperfume = MerekPerfume;
    }

    public String getNamaPerfume() {
        return namaperfume;
    }

    public void setNamaPerfume(String NamaPerfume) {
        this.namaperfume = NamaPerfume;
    }

    public String getDeskripsiPerfume() {
        return deskripsiperfume;
    }

    public void setDeskripsiPerfume(String DeskripsiPerfume) {
        this.deskripsiperfume = DeskripsiPerfume;
    }

    public String getJenisPefume() {
        return jenisperfume;
    }

    public void setJenisPefume(String JenisPefume) {
        this.jenisperfume = JenisPefume;
    }

    public Integer getUkuranPerfume() {
        return ukuranperfume;
    }

    public void setUkuranPerfume(Integer UkuranPerfume) {
        this.ukuranperfume = UkuranPerfume;
    }

    public Integer getHargaPerfume() {
        return hargaperfume;
    }

    public void setHargaPerfume(Integer HargaPerfume) {
        this.hargaperfume = HargaPerfume;
    }

    public String getGenderPerfume() {
        return genderperfume;
    }

    public void setGenderPerfume(String GenderPerfume) {
        this.genderperfume = GenderPerfume;
    }
}

