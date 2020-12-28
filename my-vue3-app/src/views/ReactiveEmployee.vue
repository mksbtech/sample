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
import { Employee } from '@/service/dto/employee';
import { Observable } from 'rxjs';
import { defineComponent, PropType } from 'vue';
import EmployeeService from '../service/EmployeeService';
// import { interval } from "rxjs";


export default defineComponent({
  name: 'EmployeeComponent',  
  props:{
    employees: Array as PropType<Array<Employee>>
    
  }, 

   data() {
        return {
            employeeService: new EmployeeService(),       
            // employees: new Observable<Employee[]>()            
        }
    },
      //  created(){
      //    this.contentService = new ContentService();
      //  },
    mounted() {
                     

          
      
    const es = new EventSource('http://localhost:8081/employee-service/reactive-employees');
   
    es.addEventListener("message", event => {
            // const employee: Employee = JSON.parse(event.data);
            // this.employees.push(data);
            console.log('Message Event');
            console.log(event.data);
            this.employees?.push(event.data);
            
        }, false);
        es.addEventListener('employee-event', event => {
            // const employee: Employee = JSON.parse(event.data);
            // this.employees.push(data);
            console.log('Employee Event');
            console.log(event);
            // this.employees?.push(event.data);
            
        }, false);
         es.addEventListener('data', (event) => {
          //  const employee: Employee = JSON.parse(event);
        console.log('Milan On data');
        console.log(event);
      }, false);
        es.addEventListener('open', event => {
        console.log('Milan Connection Opened');
         console.log(event);
        }, false);
        // es.addEventListener("disconnect", function(e) {
        //   console.log('Milan Error');
        //   es.close();
        // }, false);
         es.addEventListener("error", function(e) {           
          console.log('Milan Error:'+e.returnValue);
          es.close();
        }, false);
        es.addEventListener("stop",function(e){
          es.close()},false);
                 
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
