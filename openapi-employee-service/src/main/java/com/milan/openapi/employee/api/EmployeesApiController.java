package com.milan.openapi.employee.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.milan.openapi.employee.model.Employee;
import com.milan.openapi.employee.model.Error;
import com.milan.openapi.employee.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-01-27T11:43:33.263+05:30[Asia/Kolkata]")

@Controller
@RequestMapping("${openapi.swaggerEmployeeService.base-path:/employee-service}")
public class EmployeesApiController implements EmployeesApi {

    @Autowired
    private EmployeeService employeeService;
    
    private ObjectMapper mapper = new ObjectMapper();
    
    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EmployeesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    @ApiOperation(value = "Create an employee", nickname = "createEmployee", notes = "", tags={ "employees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Null response"),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/employees",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@ApiParam(value = ""  )  @Valid @RequestBody Employee employee) {
    	employeeService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @ApiOperation(value = "Delete specific employee", nickname = "deleteEmployeetById", notes = "", response = Employee.class, tags={ "employees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = Employee.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/employees/{employeeId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployeetById(@ApiParam(value = "The id of the employee to retrieve",required=true) @PathVariable("employeeId") String employeeId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                	Employee emp = employeeService.deleteEmployee(Integer.parseInt(employeeId));
                	if(null!=emp) {
                        try {
							ApiUtil.setExampleResponse(request,"application/json", mapper.writeValueAsString(emp));
						} catch (JsonProcessingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        break;
                    	}                    
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @ApiOperation(value = "List all employees", nickname = "listEmployees", notes = "", response = Employee.class, responseContainer = "List", tags={ "employees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An paged array employees", response = Employee.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/employees",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listEmployees(@ApiParam(value = "How many items to return at one time (max 100)") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                	List<Employee> allEmployees = employeeService.getAllEmployees(); 
                	List<Employee> empList = null;
                	if(null==limit)
                	{
                		empList = allEmployees;
                	}
                	else {
                		empList = allEmployees.subList(0, limit);
                	}
                    try {
						ApiUtil.setExampleResponse(request, "application/json", mapper.writeValueAsString(empList) );												
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @ApiOperation(value = "Info for a specific employee", nickname = "showEmployeetById", notes = "", response = Employee.class, tags={ "employees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = Employee.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/employees/{employeeId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<Employee> showEmployeetById(@ApiParam(value = "The id of the employee to retrieve",required=true) @PathVariable("employeeId") String employeeId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                	
                	Employee emp = employeeService.getEmployeeById(Integer.parseInt(employeeId));
                    try {
						ApiUtil.setExampleResponse(request, "application/json", mapper.writeValueAsString(emp));
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();						
					}
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @ApiOperation(value = "Update an employee", nickname = "updateEmployee", notes = "", tags={ "employees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Null response"),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/employees",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    public ResponseEntity<Void> updateEmployee(@ApiParam(value = ""  )  @Valid @RequestBody Employee employee) {
    	employeeService.updateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
