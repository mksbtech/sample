<template>
  <DataTable :value="employees" class="p-datatable-gridlines" sortMode="multiple">
    <template #header>
        <div>
            <Button icon="pi pi-refresh" style="float: left"/>
            List of Employees
        </div>
    </template>
    
        
    <Column field="id" header="Id" sortable=true></Column>
    <Column field="firstName" header="First Name" sortable=true></Column>
    <Column field="lastName" header="Last Name" sortable=true></Column>
    <Column field="email" header="Email" sortable=true></Column>     
</DataTable>

<!-- <div v-for="employee in employees" :key="employee.id">{{employee.email}}
  console.log('Milan')
</div> -->
</template>

<script lang="ts">
// import { Employee } from '@/service/dto/employee';
// import { Employee } from '@/service/dto/employee';
// import { Observable } from 'rxjs/internal/Observable';
// import { computed } from 'vue'
import { defineComponent, PropType } from 'vue';
import EmployeeService from '../service/EmployeeService';
// import { interval } from "rxjs";


export default defineComponent({
  name: 'EmployeeComponent',  
  props:{
    // employees: Array as PropType<Array<Employee>>
    
  }, 

   data() {
        return {
            employeeService: new EmployeeService(),
        //     columns: [
        //     {field: 'id', header: 'Id'},
        //     {field: 'name', header: 'Name'},
        //     {field: 'description', header: 'Description'},
        //     {field: 'published_at', header: 'Published On'},
        //     {field: 'image', header: 'Image'}
        // ],
            // employees: new Observable<Employee[]>()
            employees: []
             
            
        }
    },
      //  created(){
      //    this.contentService = new ContentService();
      //  },
    mounted() {
        // this.contentService.getCMSContent().then(response=>this.restaurants=response.data);  
        // this.employeeService.getEmployees().subscribe(
        //   (                    response: { data: Observable<Employee[]> })=>this.employees=response.data,
        //   (          // response=>console.log(JSON.parse(response.data)),
        //   error: any)=>console.log(error)          
          
        //   );                             
                this.employeeService.getEmployees().subscribe(response=>this.employees=response.data.data,
                response=>console.log(response.data));
                   
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
