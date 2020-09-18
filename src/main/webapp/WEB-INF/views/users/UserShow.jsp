<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">UserCRUD</h1>
    <a href="/" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Return to User list</a>
</div>
<div class="container">

<!-- Content Row -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Users details</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <tr>
                    <td>Id</td>
                    <td>${param.id}</td>
                </tr>
                <tr>
                    <td>User name</td>
                    <td>${param.userName}</td>
                </tr>
                <tr>
                    <td>Email adress</td>
                    <td>${param.email}</td>
                </tr>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/templates/footer.jsp" %>
