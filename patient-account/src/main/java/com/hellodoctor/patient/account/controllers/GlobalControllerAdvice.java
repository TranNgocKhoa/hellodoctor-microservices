package com.hellodoctor.patient.account.controllers;

import com.hellodoctor.patient.account.exceptions.ApiRuntimeException;
import com.hellodoctor.patient.account.exceptions.DBOperationException;
import com.hellodoctor.patient.account.models.ApiHeaderAdvice;
import com.hellodoctor.patient.account.models.ApiResponseAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.HandlerResultHandler;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.result.method.annotation.AbstractMessageWriterResultHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice extends AbstractMessageWriterResultHandler implements HandlerResultHandler {

    @Autowired
    public GlobalControllerAdvice(ServerCodecConfigurer serverCodecConfigurer, RequestedContentTypeResolver resolver) {
        this(serverCodecConfigurer.getWriters(), resolver, ReactiveAdapterRegistry.getSharedInstance());
    }

    /**
     * Constructor with an {@link ReactiveAdapterRegistry} instance.
     *
     * @param writers  writers for serializing to the response body
     * @param resolver to determine the requested content type
     * @param registry for adaptation to reactive types
     */
    public GlobalControllerAdvice(List<HttpMessageWriter<?>> writers,
                                  RequestedContentTypeResolver resolver, ReactiveAdapterRegistry registry) {

        super(writers, resolver, registry);
        setOrder(Ordered.HIGHEST_PRECEDENCE);
    }


    @Override
    public boolean supports(HandlerResult result) {
        MethodParameter returnType = result.getReturnTypeSource();
        Class<?> containingClass = returnType.getContainingClass();
        return (AnnotatedElementUtils.hasAnnotation(containingClass, ResponseBody.class) ||
                returnType.hasMethodAnnotation(ResponseBody.class));
    }

    @Override
    public Mono<Void> handleResult(ServerWebExchange exchange, HandlerResult result) {
        Object body = result.getReturnValue();
        MethodParameter bodyTypeParameter = result.getReturnTypeSource();
        ApiResponseAdvice<Object> apiResponseAdvice = new ApiResponseAdvice<>();
        if (body instanceof Exception) {
            setExceptionMessage(body, apiResponseAdvice);

            return writeBody(Mono.just(apiResponseAdvice), bodyTypeParameter, exchange);
        } else if (body instanceof Mono) {
            Mono apiResponseAdviceMono = Mono.class.cast(body)
                    .map(data -> {
                        apiResponseAdvice.setData(data);
                        return apiResponseAdvice;
                    }).defaultIfEmpty(apiResponseAdvice);

            return writeBody(apiResponseAdviceMono, bodyTypeParameter, exchange);
        }
        return writeBody(body, bodyTypeParameter, exchange);
    }

    private void setExceptionMessage(Object body, ApiResponseAdvice<Object> apiResponseAdvice) {
        if (body instanceof ApiRuntimeException) {
            apiResponseAdvice.setHeader((ApiRuntimeException) body);
            apiResponseAdvice.setData(null);
        } else if (body instanceof DBOperationException) {
            apiResponseAdvice.setHeader((DBOperationException) body);
            apiResponseAdvice.setData(null);
        } else if (body instanceof RuntimeException) {
            ApiHeaderAdvice apiHeaderAdvice = new ApiHeaderAdvice(false, ((RuntimeException) body).getMessage(), null);
            apiResponseAdvice.setHeader(apiHeaderAdvice);
            apiResponseAdvice.setData(null);
        }
    }

}
