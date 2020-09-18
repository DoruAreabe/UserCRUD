<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">UserCRUD</h1>
    <a href="/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Add new entity</a>
</div>

<!-- Content Row -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">List of Users</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                </thead>
                <c:forEach var="User" items="${userList}">
                    <tr>
                        <td>${User.id}</td>
                        <td>${User.userName}</td>
                        <td>${User.email}</td>
                        <td>
                            <a href="/delete?id=${User.id}">Remove</a>
                            <a href="/edit?id=${User.id}&userName=${User.userName}&email=${User.email}">Edit</a>
                            <a href="/show?id=${User.id}&userName=${User.userName}&email=${User.email}">Show</a>
                        </td>
                    </tr>
                </c:forEach>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/templates/footer.jsp" %>