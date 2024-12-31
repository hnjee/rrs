package com.jyujyu.review.api;

import com.jyujyu.review.api.request.CreateAndEditRestaurantRequest;
import com.jyujyu.review.api.request.CreateAndEditRestaurantRequestMenu;
import com.jyujyu.review.api.response.RestaurantDetailView;
import com.jyujyu.review.api.response.RestaurantView;
import com.jyujyu.review.model.RestaurantEntity;
import com.jyujyu.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {
    private final RestaurantService restaurantService;

    //1. 맛집 리스트 가져오기 API
    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    //2. 맛집 정보 가져오기 API
    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(
            @PathVariable Long restaurantId
    ){
        return restaurantService .getRestaurantDetail(restaurantId);
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
