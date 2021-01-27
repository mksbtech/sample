<template>
<div class="p-d-flex">
    <h5>Vue 3 + VeeValidate - PrimeVue Example</h5>
    <Form @submit="onSubmit" :validation-schema="schema" v-slot="{ errors }">
        <div class="p-fluid">
            <div class="p-field p-mb-2 p-mt-2">
                <label for="firstName">First Name</label>
                <Field name="firstName" type="text" class="p-inputtext" :class="{ 'invalid-firstName': errors.firstName }" placeholder="enter first name" />
                <div class="is-invalid">{{errors.firstName}}</div>
            </div>
            <div class="p-field p-mb-2 p-mt-2">
                <label for="lastName">Last Name</label>
                <Field name="lastName" type="text" class="p-inputtext" :class="{ 'invalid-lastName': errors.lastName }" placeholder="enter last name" />
                <div class="is-invalid p-mb-2 p-mt-2">{{errors.lastName}}</div>
            </div>
            <div class="p-field p-mb-2 p-mt-2">
                <label for="email">Email</label>
                <Field name="email" type="text" class="p-inputtext " :class="{ 'invalid-email': errors.email }" placeholder="enter email" />
                <div class="is-invalid">{{errors.email}}</div>
            </div>
        </div>
        <div class="p-mb-4 p-mt-4">
            <Button type="submit" label="Add" class="p-button p-button-rounded p-mt-6" />
        </div>
    </Form>
</div>
</template>

<script lang="ts">
import {
  Form,
  Field
} from 'vee-validate'
import * as Yup from 'yup'
import {
  Employee
} from '@/model/Employee'
// import EmployeeService from '@/service/EmployeeService'
import store from '@/store'
import {
  defineComponent
} from 'vue'

export default defineComponent({
  name: 'AddEmployee',
  components: {
    Form,
    Field
  },
  setup () {
    // const employeeService = new EmployeeService()
    const schema = Yup.object().shape({
      firstName: Yup.string()
        .required('First Name is required'),
      lastName: Yup.string()
        .required('Last name is required'),
      email: Yup.string()
        .required('Email is required')
        .email('Email is invalid')
    })

    const onSubmit = (values: Employee) => {
      // display form values on success
      // alert('SUCCESS!! :-)\n\n' + JSON.stringify(values, null, 4));
      //  employeeService.createEmployee(values).subscribe(
      //     response=>console.log(response.data));
      store.dispatch('create', values).then((response: {
      // eslint-disable-next-line     
              data: any
            }) => console.log(response.data))
    }
    return {
      schema,
      onSubmit
    }
  }
})
</script>

<style>
.is-invalid {
    color: red
}

.invalid-firstName {
    color: blue
}
</style>
