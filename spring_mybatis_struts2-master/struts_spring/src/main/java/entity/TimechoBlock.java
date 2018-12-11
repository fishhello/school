package entity;

import java.io.Serializable;

public class TimechoBlock implements Serializable {
    private Integer bid;

    private Byte bowner;

    private String bdescription;

    private String bname;

    private static final long serialVersionUID = 1L;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Byte getBowner() {
        return bowner;
    }

    public void setBowner(Byte bowner) {
        this.bowner = bowner;
    }

    public String getBdescription() {
        return bdescription;
    }

    public void setBdescription(String bdescription) {
        this.bdescription = bdescription == null ? null : bdescription.trim();
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }
}