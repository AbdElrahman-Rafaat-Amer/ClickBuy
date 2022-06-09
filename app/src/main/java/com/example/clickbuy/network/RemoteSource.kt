package com.example.clickbuy.network

import com.example.clickbuy.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteSource {
    suspend fun getAllProductsInCollectionByID(collectionID: String): Response<Products>
    suspend fun getProductByID(productId: String): Response<ProductParent>
    suspend fun getAllProducts(
        collectionId: String,
        vendor: String,
        productType: String
    ): Response<Products>

    suspend fun getCategoryIdByTitle(categoryTitle: String): Response<CustomCollections>
    suspend fun getAllBrands(): Response<Brands>
    suspend fun getAllProductsInSpecificCollectionByIDAndTitle(
        idCollectionDetails: String,
        categoryTitleComingFromHome: String
    ): Response<Products>

    suspend fun getAllSubCategoriesFilterForSpecificCategoryByIDAndTitle(
        idCollectionDetails: String,
        categoryTitleFromFilter: String
    ): Response<Products>

    suspend fun getSubCategories(): Response<Products>
    // suspend fun getAllSubCategoriesForSpecificCategory(collectionID: String): Response<Products>
    //  suspend fun getCustomCollectionsByID(collectionID: String): Response<CustomCollectionElement>
    suspend fun signIn(email: String): Response<CustomersList>
    suspend fun registerCustomer(customer: CustomerParent): Response<CustomerParent>

    //suspend fun getAllOrdersById(id: String): Response<Orders>
    suspend fun getAllSubCategoriesForSpecificCategory(idCollectionDetails: String): Response<SubCategories>

    suspend fun getCustomerDetails(email: String): Response<Customers>
    suspend fun getCurrencies(): Response<Currencies>
    suspend fun getQualifiedValueCurrency(to: String): Response<CurrencyConverter>

    suspend fun getAvailableCoupons(): Response<Coupons>
    suspend fun validateCoupons(code: String): Response<Coupon>
}