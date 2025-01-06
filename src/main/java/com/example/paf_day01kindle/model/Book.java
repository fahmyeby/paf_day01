package com.example.paf_day01kindle.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Book {
    private String asin;
    private String title;
    private String author;
    private String soldBy;
    private String imgUrl;
    private Float stars;
    private Integer reviews;
    private Double price;
    private String publishedDate;
    private String categoryName;

    // Getters and setters
    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Float getStars() {
        return stars;
    }

    public void setStars(Float stars) {
        this.stars = stars;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public static Book toBook(SqlRowSet rs) {
        Book b = new Book();
        b.setAsin(rs.getString("asin"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setSoldBy(rs.getString("soldBy"));
        b.setImgUrl(rs.getString("imgUrl"));
        b.setStars(rs.getFloat("stars"));
        b.setReviews(rs.getInt("reviews"));
        b.setPrice(rs.getDouble("price"));
        b.setPublishedDate(rs.getString("publishedDate"));
        b.setCategoryName(rs.getString("category_name"));
        return b;
    }
}
