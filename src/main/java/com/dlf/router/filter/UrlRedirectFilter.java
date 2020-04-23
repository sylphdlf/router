package com.dlf.router.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class UrlRedirectFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object run() {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            String uri  = (String)context.get(FilterConstants.REQUEST_URI_KEY);
            context.put(FilterConstants.REQUEST_URI_KEY, uri);
//            }else if(contentType.contains("multipart/form-data")){
//                context.put(FilterConstants.REQUEST_URI_KEY, "/file/uploadFile");
//            }
        }catch (Exception e){
            logger.error(e.getMessage());
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
