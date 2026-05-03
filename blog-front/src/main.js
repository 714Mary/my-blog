import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css' // 关键：引入样式文件

const app = createApp(App)
app.use(ElementPlus) // 关键：注册Element Plus
app.mount('#app')
