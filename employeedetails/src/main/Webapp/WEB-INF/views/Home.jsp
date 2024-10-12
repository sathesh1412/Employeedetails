<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 15px;
        }

        .table-responsive {
            overflow-x: auto;
        }

        @media (max-width: 576px) {
            table, th, td {
                font-size: 12px;
                padding: 8px;
            }
        }

        @media (min-width: 577px) and (max-width: 992px) {
            table, th, td {
                font-size: 14px;
                padding: 10px;
            }
        }

        @media (min-width: 993px) {
            table, th, td {
                font-size: 16px;
                padding: 12px;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="mt-4">Employee List</h2>

    <!-- Add New Employee Button: Centered and responsive -->
    <div class="row justify-content-center">
        <div class="col-12 col-md-6 col-lg-4">
            <form action="/addNewEmployee" method="get">
                <input type="hidden" name="AddNewEmployee">
                <button type="submit" class="btn btn-primary btn-block">Add New Employee</button>
            </form>
        </div>
    </div>

    <!-- Responsive table layout -->
    <div class="table-responsive mt-4">
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>DOB</th>
                    <th>Age</th>
                    <th>Salary</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${AllEmployees}">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.email}</td>
                        <td>${employee.dob}</td>
                        <td>${employee.age}</td>
                        <td>${employee.salary}</td>
                        <td>${employee.status ? 'Active' : 'Inactive'}</td>
                        <td>
                            <a href="/updateEmployee/${employee.id}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="/deleteEmployee/${employee.id}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
