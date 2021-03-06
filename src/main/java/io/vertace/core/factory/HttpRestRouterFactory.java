package io.vertace.core.factory;

import io.vertace.http.HttpRestRouter;

public class HttpRestRouterFactory extends AbstractFactory<HttpRestRouter> {

    @Override
    public Class<HttpRestRouter> factoryFor() {
        return HttpRestRouter.class;
    }

    @Override
    public HttpRestRouter initialize(Class<? extends HttpRestRouter> t) {
        try {
            HttpRestRouter<?> hrr = t.newInstance();
            return hrr;
        } catch(InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
