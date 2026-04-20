<template>
  <div class="container">
    <h1>我的博客</h1>

    <!-- 发文章表单 -->
    <div class="form-box">
      <input v-model="newArticle.title" placeholder="文章标题" />
      <textarea v-model="newArticle.content" placeholder="文章内容"></textarea>
      <button @click="addArticle">发布文章</button>
    </div>

    <!-- 文章列表 -->
    <div class="article-list">
      <div v-for="article in articleList" :key="article.id" class="article-item">
        <h3>{{ article.title }}</h3>
        <p>{{ article.content }}</p>
        <small>发布时间：{{ article.createTime }}</small>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

// 配置后端地址
axios.defaults.baseURL = 'http://localhost:8081'

// 文章列表和新增表单
const articleList = ref([])
const newArticle = ref({
  title: '',
  content: ''
})

// 加载文章列表
const loadArticles = async () => {
  const res = await axios.get('/article/list')
  articleList.value = res.data.data
}

// 新增文章
const addArticle = async () => {
  if (!newArticle.value.title || !newArticle.value.content) {
    alert('标题和内容不能为空！')
    return
  }
  await axios.post('/article/add', newArticle.value)
  alert('发布成功！')
  // 清空表单并刷新列表
  newArticle.value = { title: '', content: '' }
  loadArticles()
}

// 页面加载时自动获取文章列表
onMounted(() => {
  loadArticles()
})
</script>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.form-box {
  background: #f5f5f5;
  padding: 20px;
  border-radius: 8px;
  margin-bottom: 30px;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

input, textarea {
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  padding: 10px;
  background: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.article-item {
  border: 1px solid #eee;
  padding: 15px;
  margin-bottom: 15px;
  border-radius: 8px;
}
</style>
