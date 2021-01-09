<template>
    <div class="card m-3">
        <h5 class="card-header">Vue 3 + VeeValidate - Form Validation Example</h5>
        <div class="card-body">
            <Form @submit="onSubmit" :validation-schema="schema" v-slot="{ errors }">
                <div class="form-row">
                    <div class="form-group col">                       
                        <label>First Name</label>
                        <Field name="firstName" type="text" class="form-control" :class="{ 'invalid-firstName': errors.firstName }" placeholder="enter first name"/>
                        <div class="is-invalid">{{errors.firstName}}</div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col">                    
                        <label>Last Name</label>
                        <Field name="lastName" type="text" class="form-control" :class="{ 'invalid-lastName': errors.lastName }" placeholder="enter last name" />
                        <div class="is-invalid">{{errors.lastName}}</div>
                    </div>
                </div>
                <div class="form-row">                   
                    <div class="form-group col">
                        <label>Email</label>
                        <Field name="email" type="text" class="form-control" :class="{ 'invalid-email': errors.email }" placeholder="enter email" />
                        <div class="is-invalid">{{errors.email}}</div>
                    </div>
                </div>                             
                <div class="form-group">
                    <button class="btn btn-primary mr-1">Add</button>
                </div>
            </Form>
        </div>
    </div>    
</template>

<script lang="ts">
import {Form,Field} from 'vee-validate';
import * as Yup from 'yup';
import { Employee } from '@/service/dto/employee';
import EmployeeService from '@/service/EmployeeService';

export default {
    components: {
        Form,Field
        
    },
    setup() {
        const employeeService = new EmployeeService()
        const schema = Yup.object().shape({            
            firstName: Yup.string()
                .required('First Name is required'),
            lastName: Yup.string()
                .required('Last name is required'),
           
            email: Yup.string()
                .required('Email is required')
                .email('Email is invalid'),            
        });

        const onSubmit = (values: Employee)=> {
            // display form values on success
            // alert('SUCCESS!! :-)\n\n' + JSON.stringify(values, null, 4));
             employeeService.createEmployee(values).subscribe(
                response=>console.log(response.data));
        }

        return {
            schema,
            onSubmit
        };
    }
    
    
}

</script>
<style>
.is-invalid{
    color:red
}
.invalid-firstName{
    color:blue
}
</style>