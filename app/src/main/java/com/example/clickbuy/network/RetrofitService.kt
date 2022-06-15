package com.example.clickbuy.network

import com.example.clickbuy.models.*
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.Query

interface RetrofitService {

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("products.json")
    suspend fun getAllProducts(

        @Query("collection_id") id: String,
        @Query("vendor") vendor: String,
        @Query("product_type") title: String
    ): Response<Products>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("collections/{id}/products.json")
    suspend fun getAllProductsInCollectionByID(@Path("id") id: String): Response<Products>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("custom_collections.json?title={categoryTitle}")
    suspend fun getCategoryIdByTitle(
        @Path("categoryTitle") categoryTitle: String
    ): Response<CustomCollections>


    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("smart_collections.json")
    suspend fun getAllBrands(): Response<Brands>


    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("products/{id}.json")
    suspend fun getProductById(@Path("id") id: String): Response<ProductParent>

    //Get all Coupons
    @Headers(RetrofitHelper.HEADERS_ACCESS_TOKEN, RetrofitHelper.HEADERS_CONTENT_TYPE)
    @GET("price_rules/1089622311051/discount_codes.json")
    suspend fun getAvailableCoupons(): Response<Coupons>

    @Headers(RetrofitHelper.HEADERS_ACCESS_TOKEN, RetrofitHelper.HEADERS_CONTENT_TYPE)
    @GET("discount_codes/lookup.json?")
    suspend fun validateCoupons(
        @Query("code") code: String
    ): Response<Coupon>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("products.json?")
    suspend fun getAllSubCategoriesForSpecificCategory(
        @Query("fields") product_type: String,
        @Query("collection_id") id: String
    ): Response<SubCategories>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("products.json?")
    suspend fun getAllSubCategoriesForSpecificCategoryByIDAndTitle(
        @Query("collection_id") id: String,
        @Query("vendor") title: String
    ): Response<Products>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("products.json?")
    suspend fun getAllSubCategoriesFilterForSpecificCategoryByIDAndTitle(
        @Query("collection_id") id: String,
        @Query("product_type") title: String
    ): Response<Products>


    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("products.json?")
    suspend fun getSubCategories(): Response<Products>
    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    //customers/5745222516875/orders.json
    @GET("customers/{id}/orders.json")
    suspend fun getAllOrdersForSpecificCustomerById(
        @Path("id") id: String
    ): Response<Orders>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("customers.json?")
    suspend fun getCustomerDetails(
        @Query("email") email: String
    ): Response<Customers>


    @Headers(RetrofitHelper.HEADERS_ACCESS_TOKEN, RetrofitHelper.HEADERS_CONTENT_TYPE)
    @GET("currencies.json")
    suspend fun getCurrencies(
    ): Response<Currencies>

    @GET("convert?apikey=UzDffIvEj5rwG6iHMLxXMS5Cz4jsyYBK&amount=1&from=EGP")
    suspend fun getQualifiedValueCurrency(
        @Query("to") to: String
    ): Response<CurrencyConverter>



    //Bag
    @Headers(RetrofitHelper.HEADERS_ACCESS_TOKEN, RetrofitHelper.HEADERS_CONTENT_TYPE)
    @GET("draft_orders/{id}.json")
    suspend fun getAllItemInBag(@Path("id") id: String): Response<ShoppingBag>

    @Headers(RetrofitHelper.HEADERS_ACCESS_TOKEN, RetrofitHelper.HEADERS_CONTENT_TYPE)
    @PUT("draft_orders/{id}.json")
    suspend fun updateItemsInBag(
        @Path("id") id: String,
        @Body shoppingBag: ShoppingBag
    ): Response<ShoppingBag>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("customers.json?")
    suspend fun signIn(
        @Query("email") email: String
    ): Response<Customers>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @POST("customers.json")
    suspend fun registerCustomer(@Body customerParent: CustomerParent): Response<CustomerParent>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @GET("draft_orders.json?limit=250")
    suspend fun getFavourites(): Response<Favourites>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @POST("draft_orders.json")
    suspend fun addFavourite(@Body favorite: FavouriteParent): Response<FavouriteParent>

    @Headers(
        "X-Shopify-Access-Token: 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",
        "Content-Type: application/json"
    )
    @DELETE("draft_orders/{id}.json")
    suspend fun removeFavourite(@Path("id") id: String): Response<Any>
}