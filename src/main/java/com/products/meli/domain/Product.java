package com.products.meli.domain;

public class Product {

    private String productId;
    private String sellerId;
    private String title;
    private String permalink;
    private String thumbnail;
    private int soldQuantity;


    public Product(String productId, String sellerId, String title, String permalink, String thumbnail, int soldQuantity) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.title = title;
        this.permalink = permalink;
        this.thumbnail = thumbnail;
        this.soldQuantity = soldQuantity;
    }


    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
}

