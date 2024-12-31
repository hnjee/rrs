package com.jyujyu.review.api;

import com.jyujyu.review.api.request.CreateAndEditRestaurantRequest;
import com.jyujyu.review.api.request.CreateAndEditRestaurantRequestMenu;
import com.jyujyu.review.model.RestaurantEntity;
import com.jyujyu.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {
    private final RestaurantService restaurantService;

    //1. 맛집 리스트 가져오기 API
    @GetMapping("/restaurants")
    public String getRestaurants(){
        return "This is getRestaurants";
    }

    //2. 맛집 정보 가져오기 API
    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(
            @PathVariable Long restaurantId
    ){
        return "This is getRestaurant " + restaurantId;
    }

    //3. 맛집 생성 API
    @PostMapping("/restaurant")
    public RestaurantEntity createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ){
        return restaurantService.createRestaurant(request);
    }

    //4. 맛집 수정 API
    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ){
        restaurantService.editRestaurant(restaurantId, request);
    }

    //5. 맛집 삭제 API
    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        restaurantService.deleteRestaurant(restaurantId);
    }
}
