package com.vshop.tag;

import com.vshop.util.StringHelper;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @ClassName FormatTimeStap
 * @Description  自定义标签类
 * 实现格式化时间戳
 * @Author Wangyw
 */
public class FormatTimeStap extends SimpleTagSupport {

    //时间戳
    private long timestap;
    //格式
    private String format;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = this.getJspContext().getOut();
        out.println(StringHelper.getDateByTimeStamp(timestap,format));


    }

    public long getTimestap() {
        return timestap;
    }

    public void setTimestap(long timestap) {
        this.timestap = timestap;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
