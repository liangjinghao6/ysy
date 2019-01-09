<template>
  <view class="container">
    <swiper class="banner" indicator-dots="true" autoplay="true" interval="3000" duration="1000">
      <swiper-item v-for="item of brand" :key="item.brandId">
        <navigator :url="brand.brandUrl">
          <text>{{item.brandName}}</text>
          <img :src="'http://localhost:8360/iapp/file/print/' + item.brandImg" background-size="cover"/>
        </navigator>
      </swiper-item>
    </swiper>
    <view class="m-menu">
      <navigator class="item" :url="category.categoryUrl" v-for="item of category" :key="item.categoryId">
        <img :src="'http://localhost:8360/iapp/file/print/' + item.categoryIcon" background-size="cover"/>
        <text>{{item.categoryName}}</text>
      </navigator>
    </view>
    <view class="a-section a-brand">
      <view class="h">
        <navigator url="../brand/brand">
          <text class="txt">品牌制造商直供</text>
        </navigator>
      </view>
      <view class="b">
        <view class="item item-1" v-for="item of brandsGoods" :key="item.goodsId">
          <navigator :url="'/pages/brand/brandDetail?id='+item.goodsId">
            <view class="wrap">
              <img class="img" :src="'http://localhost:8360/iapp/file/print/' + item.goodsImg" mode="aspectFill" background-size="cover"/>
              <view class="mt">
                <text class="brand">{{item.goodsName}}</text>
                <text class="price">{{item.goodsPrice}}</text>
                <text class="unit">元起</text>
              </view>
            </view>
          </navigator>
        </view>
      </view>
    </view>
    <view class="a-section a-new" v-if="newGoods.length">
      <view class="h">
        <view>
          <navigator url="../newGoods/newGoods">
            <text class="txt">周一周四 · 新品首发</text>
          </navigator>
        </view>
      </view>
      <view class="b">
        <view class="item" v-for="item of newGoods" :key="item.goodsId">
          <navigator :url="'../goods/goods?id='+ item.goodsId">
            <img class="img" :src="'http://localhost:8360/iapp/file/print/' + item.goodsImg" background-size="cover"/>
            <text class="name">{{item.goodsName}}</text>
            <text class="price">￥{{item.goodsPrice}}</text>
          </navigator>
        </view>
      </view>
    </view>
    <view class="a-section a-popular" v-if="hotGoods.length">
      <view class="h">
        <view>
          <navigator url="../hotGoods/hotGoods">
            <text class="txt">人气推荐</text>
          </navigator>
        </view>
      </view>
      <view class="b">
        <view class="item" v-for="item of hotGoods" :key="item.goodsId">
          <navigator :url="'/pages/goods/goods?id=' + item.goodsId">
            <img class="img" :src="'http://localhost:8360/iapp/file/print/' + item.goodsImg" background-size="cover"/>
            <view class="right">
              <view class="text">
                <text class="name">{{item.goodsName}}</text>
                <text class="desc">{{item.description}}</text>
                <text class="price">￥{{item.goodsPrice}}</text>
              </view>
            </view>
          </navigator>
        </view>
      </view>
    </view>
    <view class="a-section a-topic" v-if="topics.length">
      <view class="h">
        <view>
          <navigator url="../topic/topic" open-type="switchTab">
            <text class="txt">专题精选</text>
          </navigator>
        </view>
      </view>
      <view class="b">
        <scroll-view scroll-x="true" class="list">
          <view class="item" v-for="item of topics" :key="item.goodsId">
            <navigator :url="'../topic/topicDetail?id=' + item.goodsId">
              <img class="img" :src="'http://localhost:8360/iapp/file/print/' + item.goodsImg" background-size="cover"/>
              <view class="np">
                <text class="name">{{item.goodsName}}</text>
                <text class="price">￥{{item.goodsPrice}}元起</text>
              </view>
              <text class="desc">{{item.description}}</text>
            </navigator>
          </view>
        </scroll-view>
      </view>
    </view>
    <view class="good-grid" v-for="(item,index) of floorGoods" :key="item.id">
      <view class="h">
        <view>
          <text>{{item.name}}</text>
        </view>
      </view>
      <view class="b">
        <block v-for="(iitem,iindex) of item.goodsList" :key="iitem.goodsId" :data-id="index">
          <view :class="  iindex % 2 == 0 ? 'item' : 'item item-b'">
            <navigator :url="'../goods/goods?id=' + iitem.goodsId" class="a">
              <img class="img" :src="iitem.list_pic_url" background-size="cover"/>
              <text class="name">{{iitem.name}}</text>
              <text class="price">￥{{iitem.retail_price}}</text>
            </navigator>
          </view>
        </block>
        <view class="item item-b item-more">
          <navigator :url="'/pages/category/category?id=' + item.id" class="more-a">
            <view class="txt">{{'更多'+item.name+'好物'}}</view>
            <image class="icon" src="../../static/images/icon_go_more.png" background-size="cover"/>
          </navigator>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
  // import api from '@/utils/api'
  //import axios from 'axios'
  //import wx from 'flyio/dist/npm/wx'
  export default {
    data () {
      return {
        newGoods: {},
        hotGoods: {},
        topics: {},
        brandsGoods: {},
        floorGoods: {},
        brand: {},
        category: {}
      }
    },
    mounted() {
      this.initCategory();
      this.initBrand();
      this.initGoods();
    },
    methods: {
      initBrand() {
        this.$http.get(`http://localhost:8360/iapp/goodsbrand/find?q=1&pageNum=1&pageSize=100`).then(response => {
          const data = response.data.result
          this.brand = data.list
          console.log(this.brand)
      //    this.listLoading = false
        })
      },
      initGoods() {
        this.$http.get(`http://localhost:8360/iapp/goods/find?q=1&pageNum=1&pageSize=100`).then(response => {
          const data = response.data.result
        //  this.hotGoods = data.list
          this.newGoods = data.list
        //  this.brandsGoods = data.list
         // this.floorGoods = data.list
         // this.topics = data.list
      //    this.listLoading = false
        })
      },
      initCategory() {
        this.$http.get(`http://localhost:8360/iapp/goodscategory/find?q=1&pageNum=1&pageSize=100`).then(response => {
          const data = response.data.result
          this.category = data.list
          console.log(this.category)
          //    this.listLoading = false
        })
      }
    }
  }
</script>

<style>
  .banner {
    width: 750 rpx;
    height: 417 rpx;
  }

  .banner image {
    width: 100%;
    height: 417 rpx;
  }

  .m-menu {
    display: flex;
    height: 181 rpx;
    width: 750 rpx;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: space-between;
    background-color: #fff;
  }

  .m-menu .item {
    flex: 1;
    display: block;
    padding: 20 rpx 0;
  }

  .m-menu image {
    display: block;
    width: 58 rpx;
    height: 58 rpx;
    margin: 0 auto;
    margin-bottom: 12 rpx;
  }

  .m-menu text {
    display: block;
    font-size: 24 rpx;
    text-align: center;
    margin: 0 auto;
    line-height: 1;
    color: #333;
  }

  .a-section {
    width: 750 rpx;
    height: auto;
    overflow: hidden;
    background: #fff;
    color: #333;
    margin-top: 20 rpx;
  }

  .a-section .h {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: center;
    height: 130 rpx;
  }

  .a-section .h .txt {
    padding-right: 30 rpx;
    background: url("http://ac-3yr0g9cz.clouddn.com/2cdba05369e10f934e54.png") right 4 rpx no-repeat;
    background-size: 16.656 rpx 27 rpx;
    display: inline-block;
    height: 36 rpx;
    font-size: 33 rpx;
    line-height: 36 rpx;
  }

  .a-brand .b {
    width: 750 rpx;
    height: auto;
    overflow: hidden;
    position: relative;
  }

  .a-brand .wrap {
    position: relative;
  }

  .a-brand .img {
    position: relative;
    left: 0;
    top: 0;
  }

  .a-brand .mt {
    position: relative;
    z-index: 2;
    padding: 27 rpx 31 rpx;
    left: 0;
    top: 0;
  }

  .a-brand .mt .brand {
    display: block;
    font-size: 33 rpx;
    height: 43 rpx;
    color: #333;
  }

  .a-brand .mt .price, .a-brand .mt .unit {
    font-size: 25 rpx;
    color: #999;
  }

  .a-brand .item-1 {
    float: left;
    width: 375 rpx;
    height: 252 rpx;
    overflow: hidden;
    border-top: 1 rpx solid #fff;
    margin-left: 1 rpx;
  }

  .a-brand .item-1:nth-child(2n+1) {
    margin-left: 0;
    width: 374 rpx;
  }

  .a-brand .item-1 .img {
    width: 375 rpx;
    height: 253 rpx;
  }

  .a-new .b {
    width: 750 rpx;
    height: auto;
    overflow: hidden;
    padding: 0 31 rpx 45 rpx 31 rpx;
  }

  .a-new .b .item {
    float: left;
    width: 302 rpx;
    margin-top: 10 rpx;
    margin-left: 21 rpx;
    margin-right: 21 rpx;
  }

  .a-new .b .item-b {
    margin-left: 42 rpx;
  }

  .a-new .b .img {
    width: 302 rpx;
    height: 302 rpx;
  }

  .a-new .b .name {
    text-align: center;
    display: block;
    width: 302 rpx;
    height: 35 rpx;
    margin-bottom: 14 rpx;
    overflow: hidden;
    font-size: 30 rpx;
    color: #333;
  }

  .a-new .b .price {
    display: block;
    text-align: center;
    line-height: 30 rpx;
    font-size: 30 rpx;
    color: #b4282d;
  }

  .a-popular {
    width: 750 rpx;
    height: auto;
    overflow: hidden;
  }

  .a-popular .b .item {
    border-top: 1px solid #d9d9d9;
    margin: 0 20 rpx;
    height: 264 rpx;
    width: 710 rpx;
  }

  .a-popular .b .img {
    margin-top: 12 rpx;
    margin-right: 12 rpx;
    float: left;
    width: 240 rpx;
    height: 240 rpx;
  }

  .a-popular .b .right {
    float: left;
    height: 264 rpx;
    width: 456 rpx;
    display: flex;
    flex-flow: row nowrap;
  }

  .a-popular .b .text {
    display: flex;
    flex-wrap: nowrap;
    flex-direction: column;
    justify-content: center;
    overflow: hidden;
    height: 264 rpx;
    width: 456 rpx;
  }

  .a-popular .b .name {
    width: 456 rpx;
    display: block;
    color: #333;
    line-height: 50 rpx;
    font-size: 30 rpx;
  }

  .a-popular .b .desc {
    width: 456 rpx;
    display: block;
    color: #999;
    line-height: 50 rpx;
    font-size: 25 rpx;
  }

  .a-popular .b .price {
    width: 456 rpx;
    display: block;
    color: #b4282d;
    line-height: 50 rpx;
    font-size: 33 rpx;
  }

  .a-topic .b {
    height: 533 rpx;
    width: 750 rpx;
    padding: 0 0 48 rpx 0;
  }

  .a-topic .b .list {
    height: 533 rpx;
    width: 750 rpx;
    white-space: nowrap;
  }

  .a-topic .b .item {
    display: inline-block;
    height: 533 rpx;
    width: 680.5 rpx;
    margin-left: 30 rpx;
    overflow: hidden;
  }

  .a-topic .b .item:last-child {
    margin-right: 30 rpx;
  }

  .a-topic .b .img {
    height: 387.5 rpx;
    width: 680.5 rpx;
    margin-bottom: 30 rpx;
  }

  .a-topic .b .np {
    height: 35 rpx;
    margin-bottom: 13.5 rpx;
    color: #333;
    font-size: 30 rpx;
  }

  .a-topic .b .np .price {
    margin-left: 20.8 rpx;
    color: #b4282d;
  }

  .a-topic .b .desc {
    display: block;
    height: 30 rpx;
    color: #999;
    font-size: 24 rpx;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }

  .good-grid {
    width: 750 rpx;
    height: auto;
    overflow: hidden;
  }

  .good-grid .h {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: center;
    height: 130 rpx;
    font-size: 33 rpx;
    color: #333;
  }

  .good-grid .b {
    width: 750 rpx;
    padding: 0 6.25 rpx;
    height: auto;
    overflow: hidden;
  }

  .good-grid .b .item {
    float: left;
    background: #fff;
    width: 365 rpx;
    margin-bottom: 6.25 rpx;
    height: 452 rpx;
    overflow: hidden;
    text-align: center;
  }

  .good-grid .b .item .a {
    height: 452 rpx;
    width: 100%;
  }

  .good-grid .b .item-b {
    margin-left: 6.25 rpx;
  }

  .good-grid .item .img {
    margin-top: 20 rpx;
    width: 302 rpx;
    height: 302 rpx;
  }

  .good-grid .item .name {
    display: block;
    width: 320 rpx;
    padding: 0 20 rpx;
    overflow: hidden;
    height: 35 rpx;
    margin: 11.5 rpx 0 22 rpx 0;
    text-align: center;
    font-size: 30 rpx;
    color: #333;
  }

  .good-grid .item .price {
    display: block;
    width: 365.625 rpx;
    height: 30 rpx;
    text-align: center;
    font-size: 30 rpx;
    color: #b4282d;
  }

  .good-grid .more-item {
    height: 100%;
    width: 100%;
  }

  .more-a {
    height: 100%;
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .good-grid .more-a .txt {
    height: 33 rpx;
    width: 100%;
    line-height: 33 rpx;
    color: #333;
    font-size: 33 rpx;
  }

  .good-grid .more-a .icon {
    margin: 60 rpx auto 0 auto;
    width: 70 rpx;
    height: 70 rpx;
  }

</style>
