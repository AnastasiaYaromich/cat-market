package com.yaromich.catmarket.ws.endpoints;

import com.yaromich.catmarket.ws.services.CategoryService;
import com.yaromich.catmarket.ws.soap.categories.GetCategoryByTitleRequest;
import com.yaromich.catmarket.ws.soap.categories.GetCategoryByTitleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.transaction.annotation.Transactional;

@Endpoint
@RequiredArgsConstructor
public class CategoryEndpoint {
    private static final String NAMESPACE_URI = "http://www.yaromich.com/catmarket/ws/categories";

    private final CategoryService categoriesService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoryByTitleRequest")
    @ResponsePayload
    @Transactional
    public GetCategoryByTitleResponse getCategoryByTitle(@RequestPayload GetCategoryByTitleRequest request){
        GetCategoryByTitleResponse response = new GetCategoryByTitleResponse();
        response.setCategory(categoriesService.getByTitle(request.getTitle()));
        return response;
    }
}