<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="菜名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入菜名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option
            v-for="dict in statusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['store:dishes:add']"
        >新增</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['store:dishes:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['store:dishes:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dishesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="类别" align="center" prop="categoryName" />
      <el-table-column label="菜名" align="center" prop="name" />
      <el-table-column label="简介" align="center" prop="descp" />
      <el-table-column label="价格(元)" align="center" prop="price" />
      <el-table-column label="状态" align="center" prop="status" :formatter="statusFormat" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['store:dishes:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['store:dishes:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdateStatus(scope.row)"
            v-hasPermi="['store:dishes:edit']"
          >变更状态</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改菜品对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">

        <el-form-item label="类别" prop="status">
          <el-select v-model="form.categoryId" placeholder="请选择类别" clearable size="small">
            <el-option
              v-for="dict in categoryOptions"
              :key="dict.id"
              :label="dict.name"
              :value="dict.id"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="菜名" prop="name">
          <el-input v-model="form.name" placeholder="请输入菜名" />
        </el-form-item>
        <el-form-item label="简介" prop="descp">
          <el-input v-model="form.descp" placeholder="请输入简介" />
        </el-form-item>
        <el-form-item label="价格(元)" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="上传图片" prop="image">
            <el-upload list-type="picture" :on-success="fileUploadSuccess" :multiple="false" :on-change="fileChange" ref="field101" :file-list="field101fileList" :action="field101Action"
              :before-upload="field101BeforeUpload">
              <el-button size="small" type="primary" icon="el-icon-upload">点击上传</el-button>
            </el-upload>
        </el-form-item>
        <img :src="form.image" width="120" height="85" />
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDishes, getDishes, delDishes, addDishes, updateDishes, exportDishes,categoryLists,updateDisheStatus } from "@/api/store/dishes";
export default {
  name: "Dishes",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 菜品表格数据
      dishesList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 状态 1:上架，2:下架字典
      statusOptions: [],
      //菜品类别
      categoryOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      field101Action: '/dev-api/common/upload',
      field101fileList: [],
    };
  },
  created() {
    this.getList();
    this.getDicts("dishes_status").then(response => {
      this.statusOptions = response.data;
    });
    this.getLeibieLis();
  },
  methods: {
    fileUploadSuccess(e,file,fileList){
      this.field101fileList = fileList;

    },
    fileChange(e){
    console.log(e,'change');
    },
    /**获取类别 */
    getLeibieLis() {
      categoryLists({}).then((res) => {
      console.log(res);
        this.categoryOptions = res.rows;
      });
    },
    /** 查询菜品列表 */
    getList() {
      this.loading = true;
      listDishes(this.queryParams).then(response => {
        this.dishesList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 状态 1:上架，2:下架字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        categoryId: null,
        name: null,
        descp: null,
        price: null,
        image: null,
        status: 0,
        createTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加菜品";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDishes(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改菜品";
      });
    },
    /** 提交按钮 */
    submitForm() {
    let urlArr = [];

    if(this.field101fileList.length!=0){
      this.field101fileList.forEach((item,index)=>{
        urlArr.push(item.response.url)
      })
    }
    console.log(urlArr);
      this.$refs["form"].validate(valid => {
      this.form.image = urlArr[0];
        if (valid) {
          if (this.form.id != null) {
            updateDishes(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
          console.log(this.form);
            addDishes(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 变更状态按钮操作 */
    handleUpdateStatus(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认变更菜品编号为"' + ids + '"的状态?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return updateDisheStatus(ids);
      }).then(() => {
        this.getList();
        this.msgSuccess("状态变更成功!");
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除菜品编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delDishes(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有菜品数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportDishes(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    },
    field101BeforeUpload(file) {
    console.log(file,'file');
      let isRightSize = file.size / 1024 / 1024 < 2
      if (!isRightSize) {
        this.$message.error('文件大小超过 2MB')
      }
      return true;
    }
  }
};
</script>
