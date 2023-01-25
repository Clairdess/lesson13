const loadAllEmployee = () => {
    cleanEmployee()
    let domain = window.location.origin;
    fetch(domain + '/employee')
        .then(response => response.json())
        .then(employee => {
            employee.forEach(employee => {
                $("#employeeGrid")
                    .append(
                        '<tr>' +
                        '<th>' + employee.employeeId + '</th>' +
                        '<td>' + employee.firstName + '</td>' +
                        '<td>' + employee.lastName + '</td>' +
                        '<td>' + employee.email + '</td>' +
                        '<td>' + employee.phoneNumber + '</td>' +
                        '<td>' + employee.hireDate + '</td>' +
                        '<td>' + employee.jobId + '</td>' +
                        '<td>' + employee.salary + '</td>' +
                        '<td>' + employee.commissionPCT + '</td>' +
                        '<td>' + employee.managerId + '</td>' +
                        '<td>' + employee.departmentId + '</td>' +
                        '</tr>');
            });
        })
}

const addNewEmployee = () => {
    const newEmployee = {
        employeeId: $("#newId").val(),
        firstName: $("#newFirstName").val(),
        lastName: $("#newLastName").val(),
        email: $("#newEmail").val(),
        phoneNumber: $("#newPhoneNumber").val(),
        hireDate: $("#newHireDate").val(),
        jobId: $("#newJobID").val(),
        salary: $("#newSalary").val(),
        commissionPCT: $("#newComPCT").val(),
        managerId: $("#newManager").val(),
        departmentId: $("#newDepartmentID").val()
    };
    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(newEmployee)
    }
    let domain = window.location.origin;
    fetch(domain + '/employee', requestOptions)
        .then(response => response.json())
        .then(data => alert('new employee: ' + JSON.stringify(data) + ' been added!'))
        .catch(error => alert('error occurred during saving new employee: ' + JSON.stringify(error)));
}

const cleanEmployee = () => {
    $("#employeeGrid").empty();
}