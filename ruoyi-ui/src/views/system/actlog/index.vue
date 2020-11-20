<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="123" prop="type">
        <el-input
          v-model="queryParams.type"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="procDefId">
        <el-input
          v-model="queryParams.procDefId"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="procInstId">
        <el-input
          v-model="queryParams.procInstId"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="executionId">
        <el-input
          v-model="queryParams.executionId"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="taskId">
        <el-input
          v-model="queryParams.taskId"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="timeStamp">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.timeStamp"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择${comment}">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="${comment}" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lockOwner">
        <el-input
          v-model="queryParams.lockOwner"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lockTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.lockTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择${comment}">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="${comment}" prop="isProcessed">
        <el-input
          v-model="queryParams.isProcessed"
          placeholder="请输入${comment}"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:actlog:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:actlog:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:actlog:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:actlog:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="actlogList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="logNr" />
      <el-table-column label="${comment}" align="center" prop="type" />
      <el-table-column label="${comment}" align="center" prop="procDefId" />
      <el-table-column label="${comment}" align="center" prop="procInstId" />
      <el-table-column label="${comment}" align="center" prop="executionId" />
      <el-table-column label="${comment}" align="center" prop="taskId" />
      <el-table-column label="${comment}" align="center" prop="timeStamp" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.timeStamp, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="${comment}" align="center" prop="userId" />
      <el-table-column label="${comment}" align="center" prop="data" />
      <el-table-column label="${comment}" align="center" prop="lockOwner" />
      <el-table-column label="${comment}" align="center" prop="lockTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lockTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="${comment}" align="center" prop="isProcessed" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:actlog:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:actlog:remove']"
          >删除</el-button>
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

    <!-- 添加或修改流程日志对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="type">
          <el-input v-model="form.type" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="procDefId">
          <el-input v-model="form.procDefId" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="procInstId">
          <el-input v-model="form.procInstId" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="executionId">
          <el-input v-model="form.executionId" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="taskId">
          <el-input v-model="form.taskId" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="timeStamp">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.timeStamp"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择${comment}">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lockOwner">
          <el-input v-model="form.lockOwner" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lockTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.lockTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择${comment}">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}" prop="isProcessed">
          <el-input v-model="form.isProcessed" placeholder="请输入${comment}" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listActlog, getActlog, delActlog, addActlog, updateActlog, exportActlog } from "@/api/system/actlog";

export default {
  name: "Actlog",
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
      // 流程日志表格数据
      actlogList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        procDefId: null,
        procInstId: null,
        executionId: null,
        taskId: null,
        timeStamp: null,
        userId: null,
        data: null,
        lockOwner: null,
        lockTime: null,
        isProcessed: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        timeStamp: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询流程日志列表 */
    getList() {
      this.loading = true;
      listActlog(this.queryParams).then(response => {
        this.actlogList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        logNr: null,
        type: null,
        procDefId: null,
        procInstId: null,
        executionId: null,
        taskId: null,
        timeStamp: null,
        userId: null,
        data: null,
        lockOwner: null,
        lockTime: null,
        isProcessed: null
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
      this.ids = selection.map(item => item.logNr)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加流程日志";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const logNr = row.logNr || this.ids
      getActlog(logNr).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改流程日志";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.logNr != null) {
            updateActlog(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addActlog(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const logNrs = row.logNr || this.ids;
      this.$confirm('是否确认删除流程日志编号为"' + logNrs + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delActlog(logNrs);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有流程日志数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportActlog(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
