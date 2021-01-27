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
</template>
<script lang="ts">
// import { Employee } from '@/service/dto/employee';
// import { Employee } from '@/service/dto/employee';
// import { Observable } from 'rxjs/internal/Observable';
// import { computed } from 'vue'
import { Employee } from '@/model/Employee'
import store from '@/store'
import { defineComponent, PropType } from 'vue'
// import EmployeeService from '../service/EmployeeService'
// import { interval } from "rxjs";
export default defineComponent({
  name: 'EmployeeList',
  props: {
    // employees: Array as PropType<Array<Employee>>
  },
  data () {
    return {
      employees: []
    }
  },
  mounted () {
    store.dispatch('fetchEmployees').then((resp) => {
      // JSON responses are automatically parsed.
      resp.subscribe((response: { data: { data: any } }) => { this.employees = response.data.data })
    })
      .catch(function (err) {
        console.log(err)
      })
  }
})
</script>

<style lang="scss" scoped>

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
