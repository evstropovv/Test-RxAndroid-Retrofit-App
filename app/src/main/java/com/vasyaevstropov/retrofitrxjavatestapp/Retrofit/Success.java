package com.vasyaevstropov.retrofitrxjavatestapp.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Success {

    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("cat_descr")
    @Expose
    private String catDescr;
    @SerializedName("goods_count")
    @Expose
    private int goodsCount;
    @SerializedName("cat_img")
    @Expose
    private String catImg;
    @SerializedName("cat_name")
    @Expose
    private String catName;
    @SerializedName("meta_data")
    @Expose
    private MetaData metaData;
    @SerializedName("childs")
    @Expose
    private String childs;
    @SerializedName("cat_url")
    @Expose
    private String catUrl;

    public String getCatId() {
        return catId;
    }

    public String getCatDescr() {
        return catDescr;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public String getCatImg() {
        return catImg;
    }

    public String getCatName() {
        return catName;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public String getChilds() {
        return childs;
    }

    public String getCatUrl() {
        return catUrl;
    }

}
