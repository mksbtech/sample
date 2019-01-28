# EmployeesApi

All URIs are relative to *http://localhost:8081/employee-service*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEmployee**](EmployeesApi.md#createEmployee) | **POST** /employees | Create an employee
[**deleteEmployeetById**](EmployeesApi.md#deleteEmployeetById) | **DELETE** /employees/{employeeId} | Delete specific employee
[**listEmployees**](EmployeesApi.md#listEmployees) | **GET** /employees | List all employees
[**showEmployeetById**](EmployeesApi.md#showEmployeetById) | **GET** /employees/{employeeId} | Info for a specific employee
[**updateEmployee**](EmployeesApi.md#updateEmployee) | **PUT** /employees | Update an employee


<a name="createEmployee"></a>
# **createEmployee**
> createEmployee(employee)

Create an employee

### Example
```java
// Import classes:
//import com.milan.openapi.employee.ApiException;
//import com.milan.openapi.employee.api.EmployeesApi;


EmployeesApi apiInstance = new EmployeesApi();
Employee employee = new Employee(); // Employee | 
try {
    apiInstance.createEmployee(employee);
} catch (ApiException e) {
    System.err.println("Exception when calling EmployeesApi#createEmployee");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **employee** | [**Employee**](Employee.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteEmployeetById"></a>
# **deleteEmployeetById**
> Employee deleteEmployeetById(employeeId)

Delete specific employee

### Example
```java
// Import classes:
//import com.milan.openapi.employee.ApiException;
//import com.milan.openapi.employee.api.EmployeesApi;


EmployeesApi apiInstance = new EmployeesApi();
String employeeId = "employeeId_example"; // String | The id of the employee to retrieve
try {
    Employee result = apiInstance.deleteEmployeetById(employeeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmployeesApi#deleteEmployeetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **employeeId** | **String**| The id of the employee to retrieve |

### Return type

[**Employee**](Employee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listEmployees"></a>
# **listEmployees**
> List&lt;Employee&gt; listEmployees(limit)

List all employees

### Example
```java
// Import classes:
//import com.milan.openapi.employee.ApiException;
//import com.milan.openapi.employee.api.EmployeesApi;


EmployeesApi apiInstance = new EmployeesApi();
Integer limit = 56; // Integer | How many items to return at one time (max 100)
try {
    List<Employee> result = apiInstance.listEmployees(limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmployeesApi#listEmployees");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many items to return at one time (max 100) | [optional]

### Return type

[**List&lt;Employee&gt;**](Employee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="showEmployeetById"></a>
# **showEmployeetById**
> Employee showEmployeetById(employeeId)

Info for a specific employee

### Example
```java
// Import classes:
//import com.milan.openapi.employee.ApiException;
//import com.milan.openapi.employee.api.EmployeesApi;


EmployeesApi apiInstance = new EmployeesApi();
String employeeId = "employeeId_example"; // String | The id of the employee to retrieve
try {
    Employee result = apiInstance.showEmployeetById(employeeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmployeesApi#showEmployeetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **employeeId** | **String**| The id of the employee to retrieve |

### Return type

[**Employee**](Employee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateEmployee"></a>
# **updateEmployee**
> updateEmployee(employee)

Update an employee

### Example
```java
// Import classes:
//import com.milan.openapi.employee.ApiException;
//import com.milan.openapi.employee.api.EmployeesApi;


EmployeesApi apiInstance = new EmployeesApi();
Employee employee = new Employee(); // Employee | 
try {
    apiInstance.updateEmployee(employee);
} catch (ApiException e) {
    System.err.println("Exception when calling EmployeesApi#updateEmployee");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **employee** | [**Employee**](Employee.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

