import { createApp } from 'vue';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import * as ElementPlusIconsVue from '@element-plus/icons-vue';
import App from './App.vue';
import router from './router';
import axios from 'axios';
import store from './utils/store.js'
import { setupI18n } from './utils/i18n.js';

const app = createApp(App);
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(router);
app.use(store);
app.use(ElementPlus);
app.use(setupI18n);
app.config.globalProperties.$axios = axios;
app.mount('#app');
