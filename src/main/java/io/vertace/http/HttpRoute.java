package io.vertace.http;

import io.vertace.http.context.HttpParamContext;
import io.vertace.http.context.RequestContext;
import io.vertace.http.context.ResponseContext;
import io.vertace.http.handler.HttpParamHandler;
import io.vertace.http.handler.HttpRouteHandler;
import io.vertace.http.handler.RequestResponseHandler;
import io.vertx.core.http.HttpMethod;

public class HttpRoute {

    private String path;
    private HttpMethod httpMethod;
    private HttpRouteHandler httpRouteHandler;

    public HttpRoute(String path, HttpMethod httpMethod, HttpRouteHandler httpRouteHandler) {
        this.path = path;
        this.httpMethod = httpMethod;
        this.httpRouteHandler = httpRouteHandler;
    }

    public void register() {
        /*Bace.app().httpServer().router().route(path).method(httpMethod).handler(rctx -> {
            if(httpRouteHandler instanceof RequestResponseHandler) {
                ((RequestResponseHandler)httpRouteHandler).handle(new RequestContext(rctx), new ResponseContext(rctx));
            } else if(httpRouteHandler instanceof HttpParamHandler) {
                ((HttpParamHandler)httpRouteHandler).handle(new HttpParamContext(rctx));
            }
        });*/
    }

    public String toString() {
        return httpMethod + " " + path;
    }

    @Override
    public boolean equals(Object o) {
        //TODO: ensure proper implementation
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        HttpRoute httpRoute = (HttpRoute)o;

        if(!path.equals(httpRoute.path)) return false;
        return httpMethod == httpRoute.httpMethod;

    }

    @Override
    public int hashCode() {
        //TODO: ensure proper implementation
        int result = path.hashCode();
        result = 31 * result + httpMethod.hashCode();
        return result;
    }
}
