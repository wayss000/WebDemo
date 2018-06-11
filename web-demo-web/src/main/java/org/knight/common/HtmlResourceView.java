package org.knight.common;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

/**
 * @author Wayss
 * @date 2018/4/16
 */
public class HtmlResourceView extends InternalResourceView {

    @Override
    public boolean checkResource(Locale locale){
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        // 判断该页面是否存在
        return file.exists();
    }
}
