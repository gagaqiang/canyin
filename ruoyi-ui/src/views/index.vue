<template>
  <div class="dashboard-editor-container">

    <panel-group
      :totalMoney="totalMoney"
      :todayMoney="todayMoney"
      :todayOrders="todayOrders"
      :totalOrder="totalOrder"
      @handleSetLineChartData="handleSetLineChartData" />

    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
      <line-chart :chart-data="lineChartData" />
    </el-row>

    <el-row :gutter="32">
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
<!--          <raddar-chart />-->
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
<!--          <pie-chart />-->
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
<!--          <bar-chart />-->
        </div>
      </el-col>
    </el-row>


  </div>
</template>

<script>
import PanelGroup from './dashboard/PanelGroup'
import LineChart from './dashboard/LineChart'
import {getOrderPriceReport} from '@/api/report'

const lineChartData = {
  newVisitis: {
    expectedData: [100, 120, 161, 134, 105, 160, 165],
    actualData: [120, 82, 91, 154, 162, 140, 145]
  }
}

export default {
  name: 'Index',
  components: {
    PanelGroup,
    LineChart
  },
  data() {
    return {
      lineChartData: {expectedData: [], actualData: []},
      totalMoney: 0,
      todayMoney: 0,
      todayOrders: 0,
      totalOrder: 0,
    }
  },
  created() {
    this.getOrder();
  },
  methods: {
    handleSetLineChartData(type) {
      this.lineChartData = lineChartData[type]
    },
    getOrder(){
      getOrderPriceReport().then(res => {
        console.log(res);
        this.todayMoney = res.data.todayMoney;
        this.todayOrders = res.data.todayOrders;
        this.totalMoney = res.data.totalMoney;
        this.totalOrder = res.data.totalOrder;
        const arr = res.data.dateMoneys;
        const obj = {}
        if(Array.isArray(arr)){
          let a1 = [];
          let a2 = [];
          arr.forEach(ele => {
            a1.push(ele.date);
            a2.push(ele.money);
          })
          obj.expectedData = a1;
          obj.actualData = a2;
          this.lineChartData = obj;
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  position: relative;

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

@media (max-width:1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}
</style>
