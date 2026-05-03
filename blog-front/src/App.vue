<template>
  <div style="width: 800px; margin: 50px auto;">
    <h2 style="text-align: center;">博客文章管理</h2>

    <!-- 新增按钮 -->
    <el-button type="primary" @click="add">新增文章</el-button>

    <!-- 文章列表 -->
    <el-table :data="list" border style="width: 100%; margin-top: 20px;">
      <el-table-column prop="id" label="ID" />
      <el-table-column prop="title" label="标题" />
      <el-table-column prop="content" label="内容" />
      <el-table-column label="操作">
        <template #default="scope">
          <!-- 修改按钮 -->
          <el-button type="success" size="mini" @click="handleEdit(scope.row)">修改</el-button>
          <!-- 删除按钮 -->
          <el-button type="danger" size="mini" @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 新增/修改 弹窗 -->
    <el-dialog v-model="dialogVisible" title="文章信息">
      <el-form label-width="80px">
        <el-form-item label="标题">
          <el-input v-model="form.title" />
        </el-form-item>
        <el-form-item label="内容">
          <el-input v-model="form.content" type="textarea" :rows="3" />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确认保存</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { ElMessage, ElMessageBox } from 'element-plus'

const list = ref([])
const dialogVisible = ref(false)
const form = ref({ id: '', title: '', content: '' })

// 页面加载时查询所有文章
onMounted(() => {
  axios.get('http://localhost:8081/article/list').then(res => {
    list.value = res.data.data
  })
})

// 打开新增弹窗
const add = () => {
  form.value = { id: '', title: '', content: '' }
  dialogVisible.value = true
}

// 打开修改弹窗
const handleEdit = (row) => {
  form.value = { ...row }
  dialogVisible.value = true
}

// 保存（新增 + 修改 二合一）
const save = () => {
  if (form.value.id) {
    // 修改
    axios.put('http://localhost:8081/article/update', form.value).then(() => {
      ElMessage.success('修改成功')
      dialogVisible.value = false
      onMounted()
    })
  } else {
    // 新增
    axios.post('http://localhost:8081/article/add', form.value).then(() => {
      ElMessage.success('新增成功')
      dialogVisible.value = false
      onMounted()
    })
  }
}

// 删除
const handleDelete = (id) => {
  ElMessageBox.confirm('确定要删除吗？', '提示', { type: 'warning' }).then(() => {
    axios.delete('http://localhost:8081/article/delete/' + id).then(() => {
      ElMessage.success('删除成功')
      onMounted()
    })
  })
}
</script>