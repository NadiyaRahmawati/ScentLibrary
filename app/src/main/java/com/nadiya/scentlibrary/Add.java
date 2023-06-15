package com.nadiya.scentlibrary;

import android.os.Parcel;
import android.os.Parcelable;

public class Add implements Parcelable {
    private String id;
    private String MerekPerfume;
    private String NamaPerfume;
    private String DeskripsiPerfume;
    private String JenisPefume;
    private Integer UkuranPerfume;
    private Integer HargaPerfume;
    private String GenderPerfume;

    protected Add(Parcel in) {
        id = in.readString();
        MerekPerfume = in.readString();
        NamaPerfume = in.readString();
        DeskripsiPerfume = in.readString();
        JenisPefume = in.readString();
        UkuranPerfume = in.readInt();
        HargaPerfume = in.readInt();
        GenderPerfume = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(MerekPerfume);
        dest.writeString(NamaPerfume);
        dest.writeString(DeskripsiPerfume);
        dest.writeString(JenisPefume);
        dest.writeInt(UkuranPerfume);
        dest.writeInt(HargaPerfume);
        dest.writeString(GenderPerfume);
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
        return MerekPerfume;
    }

    public void setMerekPerfume(String MerekPerfume) {
        this.MerekPerfume = MerekPerfume;
    }

    public String getNamaPerfume() {
        return NamaPerfume;
    }

    public void setNamaPerfume(String NamaPerfume) {
        this.NamaPerfume = NamaPerfume;
    }

    public String getDeskripsiPerfume() {
        return DeskripsiPerfume;
    }

    public void setDeskripsiPerfume(String DeskripsiPerfume) {
        this.DeskripsiPerfume = DeskripsiPerfume;
    }

    public String getJenisPefume() {
        return JenisPefume;
    }

    public void setJenisPefume(String JenisPefume) {
        this.JenisPefume = JenisPefume;
    }

    public Integer getUkuranPerfume() {
        return UkuranPerfume;
    }

    public void setUkuranPerfume(Integer UkuranPerfume) {
        this.UkuranPerfume = UkuranPerfume;
    }

    public Integer getHargaPerfume() {
        return HargaPerfume;
    }

    public void setHargaPerfume(Integer HargaPerfume) {
        this.HargaPerfume = HargaPerfume;
    }

    public String getGenderPerfume() {
        return GenderPerfume;
    }

    public void setGenderPerfume(String GenderPerfume) {
        this.GenderPerfume = GenderPerfume;
    }
}

