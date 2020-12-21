<template>
  <DataTable :value="cars" class="p-datatable-gridlines">
    <Column v-for="col of columns" :field="col.field" :header="col.header" :key="col.field"></Column>
</DataTable>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import CarService from '../service/CarService'

export default defineComponent({
  name: 'Car',
   data() {
        return {
            carService: new CarService(),
            columns: [
            {field: 'vin', header: 'Vin'},
            {field: 'year', header: 'Year'},
            {field: 'brand', header: 'Brand'},
            {field: 'color', header: 'Color'}
        ],
            cars: null
        }
    },
       
    mounted() {
        this.carService.getCarsSmall().then(data => this.cars = data);
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
