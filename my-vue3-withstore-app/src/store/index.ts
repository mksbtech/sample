import { Employee } from '@/model/Employee'
import Axios from 'axios-observable'
import { createStore } from 'vuex'
// import {EmployeeService} from '../service/EmployeeService'

export default createStore({
  state: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    employee: {
      namespaced: false,

      // module assets
      state: () => ({ employeeList: [], employee: Employee }), // module state is already nested and not affected by namespace option
      //   getters: {
      //     fetchEmployees () {try{
      //     Axios.defaults.headers.common['Accept']="application/json";
      //     Axios.defaults.headers.common['Content-Type']="application/json";
      //     return Axios.get<any>('http://localhost:8082/employee-service/employees');
      //     // return resp;
      //   }catch(error){console.log(error);}
      // } // -> getters['account/isAdmin']
      //   },
      actions: {
        create (state, employee: Employee) {
          try {
            Axios.defaults.headers.common.Accept = 'application/json'
            Axios.defaults.headers.common['Content-Type'] = 'application/json'
            return Axios.post<any>('http://localhost:8082/employee-service/employees', employee)
          } catch (error) { console.log(error) }
        },
        fetchEmployees (state) {
          try {
            Axios.defaults.headers.common.Accept = 'application/json'
            Axios.defaults.headers.common['Content-Type'] = 'application/json'
            return Axios.get<any>('http://localhost:8082/employee-service/employees')
          } catch (error) { console.log(error) }
        }
      },
      mutations: {
        createEmployee () { return 'sample' } // -> commit('account/login')
      }
    }
  }
}
)
