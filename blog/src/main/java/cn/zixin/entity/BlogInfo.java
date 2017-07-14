package cn.zixin.entity;

/**
 * Created by benxin on 2017/7/2.
 */
public class BlogInfo {
    private Integer blogid;
    private String blogAuthor;
    private String blogAdress;
    private Boolean blogDel;

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public String getBlogAdress() {
        return blogAdress;
    }

    public void setBlogAdress(String blogAdress) {
        this.blogAdress = blogAdress;
    }

    public Boolean getBlogDel() {
        return blogDel;
    }

    public void setBlogDel(Boolean blogDel) {
        this.blogDel = blogDel;
    }
}
