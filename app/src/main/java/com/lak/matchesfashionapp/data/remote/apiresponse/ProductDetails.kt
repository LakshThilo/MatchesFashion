package com.lak.matchesfashionapp.data.remote.apiresponse

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

//@Entity(tableName ="products")
data class ProductDetails(
    //@PrimaryKey(autoGenerate = true)
    var  id : Int? =null,
    val code: String,
    val description: String,
    val designer: Designer,
    val name: String,
    val price: Price,
    val priceRange: String,
    val primaryImageMap: PrimaryImageMap,
    val summary: String,
    val url: String,

)

class Converters {

   /* @TypeConverter
    fun fromImageToString(image: PrimaryImageMap): String {
        return image.medium.url
    }

    @TypeConverter
    fun fromStringToImage(name: String): PrimaryImageMap {
        return PrimaryImageMap()
    }*/

    @TypeConverter
    fun fromDesignerToString(designer: Designer): String {
        return designer.name
    }

    @TypeConverter
    fun fromStringToDesigner(name: String): Designer {
        return Designer(name)
    }

    @TypeConverter
    fun fromPriceToString(price: Price): String {
        return price.formattedValue
    }

    @TypeConverter
    fun fromStringToPrice(price: String): Price {
        return Price(price)
    }
}


/*
val addToCartDisabled: String,
val addToCartDisabledMessage: String,
val approvalStatus: String,
val availableForPickup: String,
val averageRating: String,
val baseCode: String,
val baseOptions: String,
val baseProduct: String,
val carouselImages: String,
val catLevel2: String,
val catLevel2Name: String,
val categories: String,
val cites: String,
val classifications: String,
val code: String,
val colourProducts: String,
val comingSoon: Boolean,
val configurable: String,
val countryOfOrigin: String,
val curated: Boolean,
val description: String,
val designer: Designer,
val designerUrl: String,
val detailBullets: String,
val firstCategoryNameList: String,
val formattedFreshnessDate: String,
val freshnessDate: Long,
val fulfillFromStore: String,
val futureStocks: String,
val galleryImageMapSize: String,
val galleryImageMaps: List<GalleryImageMap>,
val garmentType: String,
val genderShortName: String,
val genders: List<Gender>,
val globalID: String,
val hasCitesRestriction: String,
val hasVideo: String,
val hasZoomImages: String,
val images: String,
val indicativePrice: String,
val isBatchGiftProduct: Boolean,
val isOneSize: String,
val isVisibleAfterLastSold: Boolean,
val keywords: String,
val leafCategories: String,
val lookbookDescription: String,
val lookbookId: String,
val manufacturer: String,
val markDown: String,
val multidimensional: String,
val myStylistOnly: Boolean,
val name: String,
val navDepartment: String,
val navDivision: String,
val nonRootSuperCategories: String,
val numberOfReviews: String,
val outfits: String,
val potentialPromotions: String,
val price: Price,
val priceRange: String,
val primaryImageMap: PrimaryImageMap,
val productReferences: String,
val purchasable: String,
val refinementColour: String,
val reviews: String,
val season: String,
val sellableInCurrentCountry: String,
val siteProperties: String,
val sizeAndFitInfo: List<String>,
val sizeList: List<Size>,
val slug: String,
val slugVisibleOnPDP: Boolean,
val stock: String,
val stockCount: String,
val stockFragment: String,
val stockValue: String,
val styleItWithProducts: String,
val styleNotes: String,
val summary: String,
val taxAndDutyMessage: String,
val titleOverride: String,
val url: String,
val variantMatrix: String,
val variantOptions: String,
val variantType: String,
val videoHasModel: Boolean,
val videoIs360: Boolean,
val videoUrl: String,
val viewable: Boolean,
val volumePrices: String,
val volumePricesFlag: String*/
