package cn.zengmingyang.mobile.recyclerviewcourse;

/**
 * Created by AJDX3906 on 2016/12/1.
 */

public class ItemData {
    private String title;
    private String grade;


    public ItemData(String title , String grade){
        this.grade = grade;
        this.title = title;


    }

    public String getTitle() {
        return title;
    }

    public String getGrade(){
        return grade;
    }




}
