import { createApp } from 'vue'
import VueRx from "@nopr3d/vue-next-rx";
import App from './App.vue'
import router from './router'
import store from './store'
import PrimeVue from 'primevue/config';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import Button from 'primevue/button';



const app = createApp(App)
app.use(store)
app.use(router)
app.use(PrimeVue)
app.use(VueRx)

app.component('DataTable', DataTable);
app.component('Column', Column);
app.component('Button', Button);
app.mount('#app')
