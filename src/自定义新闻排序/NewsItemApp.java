package 自定义新闻排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewsItemApp {
    public static void main(String[] args) {
        List<NewsItem> news = new ArrayList<>();
        sort(news);
        System.out.println("排序前: \n"+news);
        Collections.sort(news,NewsItem::compareTo);
        System.out.println("排序后: \n"+news);
        Collections.sort(news);
        System.out.println("排序后(实体类): \n"+news);
    }
    public static void sort(List<NewsItem> news){
        news.add(new NewsItem("日本百年beauty 😀",53,new Date(System.currentTimeMillis()-1000*60*60)));
        news.add(new NewsItem("中国百年beauty 😀",57,new Date(System.currentTimeMillis()+1000*60*60)));
        news.add(new NewsItem("美国百年beauty 😀",52,new Date(System.currentTimeMillis()-1000*10*60)));
        news.add(new NewsItem("瑞典百年beauty 😀",51,new Date(System.currentTimeMillis()-1000*20*60)));
        news.add(new NewsItem("法国百年beauty 😀",56,new Date(System.currentTimeMillis()+1000*30*60)));
    }
}
