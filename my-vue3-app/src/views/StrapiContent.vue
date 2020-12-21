<template>
  <DataTable :value="restaurants" class="p-datatable-gridlines" sortMode="multiple">
    <template #header>
        <div>
            <Button icon="pi pi-refresh" style="float: left"/>
            List of Strapi Content
        </div>
    </template>
    <!-- <Column v-for="col of columns" :field="col.field" :header="col.header" :sortable="true" :key="col.field"></Column> -->
    <!-- <template #header/>-->
        
    <Column field="id" header="Id" sortable="true"></Column>
    <Column field="name" header="Name" sortable="true"></Column>
    <Column field="description" header="Description" sortable="true"></Column>
    <Column field="published_at" header="Published On" sortable="true"></Column>
    <Column field="image" header="Image">
            <template #body="slotProps">
            <img :src="slotProps.data.image" />        
            </template>
        </Column>     
</DataTable>
</template>

<script lang="ts">
import { Restaurant } from '@/service/dto/restaurant';
import { defineComponent } from 'vue';
import ContentService from '../service/ContentService';
import { interval } from "rxjs";

export default defineComponent({
  name: 'StrapiContent',
  
   data() {
        return {
            contentService: new ContentService(),
        //     columns: [
        //     {field: 'id', header: 'Id'},
        //     {field: 'name', header: 'Name'},
        //     {field: 'description', header: 'Description'},
        //     {field: 'published_at', header: 'Published On'},
        //     {field: 'image', header: 'Image'}
        // ],
            restaurants: []
        }
    },
      //  created(){
      //    this.contentService = new ContentService();
      //  },
    mounted() {
        // this.contentService.getCMSContent().then(response=>this.restaurants=response.data);  
        this.contentService.getRestaurants().subscribe(response=>this.restaurants=response.data);     
    }
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
