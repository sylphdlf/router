package com.dlf.router.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UrlRedirectFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object run() {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            HttpServletRequest request = context.getRequest();
            System.out.println(request.getRequestURI());
            String contentType = request.getHeader("Content-Type");
            //feign client无法传递header?
            if(contentType.contains("application/json")){
//                ServletInputStream inputStream = request.getInputStream();
//                String copyToString = StreamUtils.copyToString(inputStream, Charset.defaultCharset());
//                if(!StringUtils.isEmpty(copyToString)) {
//                    JSONObject jsonObject = JSONObject.parseObject(copyToString);
//                    logger.info("userId:" + jsonObject.get("userId"));
//                    context.put(FilterConstants.REQUEST_URI_KEY, jsonObject.get("action"));
//                }
                context.put(FilterConstants.REQUEST_URI_KEY, "");
            }else if(contentType.contains("multipart/form-data")){
                context.put(FilterConstants.REQUEST_URI_KEY, "/file/uploadFile");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

}
