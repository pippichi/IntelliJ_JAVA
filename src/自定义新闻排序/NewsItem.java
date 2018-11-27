package 自定义新闻排序;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsItem implements java.lang.Comparable<NewsItem>{
    private String title;
    private int hits;
    private Date pubTime;

    @Override
    public int compareTo(NewsItem o) {
        //先时间
        int result = 0;
        result = this.pubTime.compareTo(o.pubTime);//降序
        if(result==0){
            //再点击
            result = this.hits - o.hits;//升序
            if(result==0){
                //再标题
                result = this.title.compareTo(o.title);//降序
            }
        }
        return result;
    }

    public NewsItem(String title, Date pubTime) {
        this.title = title;
        this.pubTime = pubTime;
    }

    public NewsItem(String title, int hits, Date pubTime) {
        this.title = title;
        this.hits = hits;
        this.pubTime = pubTime;
    }

    public NewsItem() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("时间: ").append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(pubTime));
        sb.append("标题: ").append(title);
        sb.append("点击量: ").append(hits).append("\n");
        return sb.toString();
    }
}
