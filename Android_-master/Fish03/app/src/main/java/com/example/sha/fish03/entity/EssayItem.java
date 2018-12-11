package com.example.sha.fish03.entity;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;

public class EssayItem extends LitePalSupport implements Serializable {
    private int id;
    private String essayTitle;//活动标题
    private String createTime;//活动创建时间
    private String essayText;//活动内容
    private int essayAutor;//活动作者id
    private int likes;//活动参与人数
    private int imageId;

    public EssayItem(String essayTitle, int imageId) {
        this.essayTitle = essayTitle;
        this.imageId = imageId;
    }

    public EssayItem() {
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEssayTitle() {
        return essayTitle;
    }

    public void setEssayTitle(String essayTitle) {
        this.essayTitle = essayTitle;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEssayText() {
        return essayText;
    }

    public void setEssayText(String essayText) {
        this.essayText = essayText;
    }

    public int getEssayAutor() {
        return essayAutor;
    }

    public void setEssayAutor(int essayAutor) {
        this.essayAutor = essayAutor;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "EssayItem{" +
                "id=" + id +
                ", essayTitle='" + essayTitle + '\'' +
                ", createTime='" + createTime + '\'' +
                ", essayText='" + essayText + '\'' +
                ", essayAutor=" + essayAutor +
                ", likes=" + likes +
                ", imageId=" + imageId +
                '}';
    }
}
