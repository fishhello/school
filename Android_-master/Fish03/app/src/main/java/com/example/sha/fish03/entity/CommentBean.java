package com.example.sha.fish03.entity;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
import java.util.List;

/**
 * 评论bean
 */
public class CommentBean extends LitePalSupport implements Serializable {
    private int code;
    private String message;
    private Data data;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }

    public class Data {

        private int total;
        private List<CommentDetailBean> list;
        public void setTotal(int total) {
            this.total = total;
        }
        public int getTotal() {
            return total;
        }

        public void setList(List<CommentDetailBean> list) {
            this.list = list;
        }
        public List<CommentDetailBean> getList() {
            return list;
        }

    }

    @Override
    public String toString() {
        return "CommentBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
