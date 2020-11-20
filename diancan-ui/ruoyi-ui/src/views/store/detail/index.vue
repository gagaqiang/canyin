<template>
  <div class="app-container">
      <el-row>
        <el-col :span="4">
          <ul class="st-ul">
            <li v-for="(item,index) in typeList" :key="index" @click="handleType(item)">{{item.name}}</li>
          </ul>
        </el-col>
        <el-col :span="20">
          <div class="pro-list" v-for="item in dataList" :key="item.id">
            <img :src="item.image"/>
            <span>{{item.name}}</span>
            <el-button icon="el-icon-circle-plus-outline" @click="add(item)">加入购物车</el-button>
          </div>
          <div style="clear: both"></div>
        </el-col>
      </el-row>
    <div class="shopping" @click="seeDetails">
      {{cont ? cont : '购物车'}}
    </div>
    <el-dialog title="购物车" :visible.sync="visible">
        <ul>
          <li v-for="item in addArr" :key="item.id">{{item.name + '------  单价' + item.price+ '元'}}</li>
        </ul>
      <div slot="footer" class="dialog-footer">
        <el-button @click="visible = false">取 消</el-button>
        <el-button type="primary" @click="submit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

  import { getcategoryList, getDishesBycateidList,addShoping } from "@/api/orderon";

export default {
  name: "Detail",
  data() {
    return {
      typeList: [],
      dataList: [],
      cont: 0,
      ids: [],
      addArr: [],
      visible: false
    };
  },
  created() {
    this.getcategoryFun()
  },
  methods: {
    getcategoryFun() {
      getcategoryList().then(res => {
        this.typeList = res.data;
      })
    },
    handleType(row) {
      getDishesBycateidList(row.id).then(res => {
        this.dataList = res.data;
      })
    },
    add(row) {
      this.cont++;
      this.ids.push(row.id);
      this.addArr.push(row);
    },
    seeDetails() {
      this.visible = true;
    },
    submit() {
      addShoping(this.ids).then(() => {
        this.visible = false;
        this.cont = 0;
        this.ids = [];
        this.addArr = [];
        this.msgSuccess("下单成功,请等待");
      })
    }
  }
};
</script>

<style>
  .pro-list {
    width: 120px;
    margin-top: 15px;
    margin-left: 20px;
    float: left;
  }
  .pro-list img {
    display: block;
    width: 100%;
  }
  .pro-list span {
    display: block;
    width: 100%;
    text-align: center;

  }
  .shopping {
    position: fixed;
    width: 40px;
    height: 40px;
    border-radius: 40px;
    background-color: red;
    right: 15px;
    bottom: 15px;
    text-align: center;
    line-height: 40px;
    font-size: 12px;
    color: #fff;
  }
  .st-ul {
    list-style: none;
  }
  .st-ul li {
    margin-top: 15px;
  }
</style>
