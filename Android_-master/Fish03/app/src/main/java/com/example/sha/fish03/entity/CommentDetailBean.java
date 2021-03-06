package com.example.sha.fish03.entity;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
import java.util.List;

public class CommentDetailBean extends LitePalSupport implements Serializable {
    private int id;
    private String nickName;
    private String userLogo;
    private String content;
    private String imgId;
    private int essayId;
    private int replyTotal;
    private String createDate;
    private List<ReplyDetailBean> replyList;

    public CommentDetailBean(int essayId,String nickName, String content,  String createDate) {
        this.nickName = nickName;
        this.content = content;
        this.essayId = essayId;
        this.createDate = createDate;
    }

    public int getEssayId() {
        return essayId;
    }

    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getNickName() {
        return nickName;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }
    public String getUserLogo() {
        return userLogo;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }
    public String getImgId() {
        return imgId;
    }

    public void setReplyTotal(int replyTotal) {
        this.replyTotal = replyTotal;
    }
    public int getReplyTotal() {
        return replyTotal;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getCreateDate() {
        return createDate;
    }

    public void setReplyList(List<ReplyDetailBean> replyList) {
        this.replyList = replyList;
    }
    public List<ReplyDetailBean> getReplyList() {
        return replyList;
    }

    @Override
    public String toString() {
        return "CommentDetailBean{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", userLogo='" + userLogo + '\'' +
                ", content='" + content + '\'' +
                ", imgId='" + imgId + '\'' +
                ", replyTotal=" + replyTotal +
                ", createDate='" + createDate + '\'' +
                ", replyList=" + replyList +
                '}';
    }
}
